package com.demo.boot.conf.shiro;

import com.github.pagehelper.util.StringUtil;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* @Description: shiro相关配置
* @Author:       tianjun
* @date:         2019/7/23 17:06
*/
@Configuration
public class ShiroConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.shiro.redis.timeout}")
    private int timeout;
    @Value("${spring.shiro.sessionTimeOut}")
    private int sessionTimeOut;
    
    /**
    * 密码匹配凭证管理器
    * @author      tianjun
    * @date        2019/7/24 13:56
    * @param
    * @return      
     */
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);// 散列的次数，比如散列两次，相当于
        return hashedCredentialsMatcher;
    }

    /**
    * 配置shiro 用到的缓存对象redis信息
    * @author      tianjun
    * @date        2019/7/30 13:59
    * @param
    * @return
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        if(StringUtil.isNotEmpty(password)){
            redisManager.setPassword(password);
        }
        redisManager.setPort(port);
        redisManager.setExpire(sessionTimeOut);// 配置过期时间
        redisManager.setTimeout(timeout);
        // redisManager.setPassword(password);
        return redisManager;
    }

    /**
    * cacheManager 缓存 redis实现
    * @author      tianjun
    * @date        2019/7/30 13:59
    * @param
    * @return
     */
    @Bean(name="cacheManager")
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }


    /**
    * shiro Realm 继承自AuthorizingRealm的自定义Realm,即指定Shiro验证用户登录的类为自定义的
     *  realm 可以理解为用户信息的安全数据源
    * @author      tianjun
    * @date        2019/7/30 13:44
    * @param
    * @return
     */
    @Bean(name="sysShiroRealm")
    public SysShiroRealm sysShiroRealm(
            @Qualifier(value="hashedCredentialsMatcher") HashedCredentialsMatcher matcher,
            RedisCacheManager cacheManager) {
        SysShiroRealm realm = new SysShiroRealm();
        /**
         * 将 credentialsMatcher 赋值给 sysShiroRealm，sysShiroRealm 继承了 AuthenticatingRealm，其在调用 getAuthenticationInfo 方法获取到 AuthenticationInfo 信息后，
         * 会使用 credentialsMatcher 来验证凭据是否匹配，如果不匹配将抛出 IncorrectCredentialsException 异常
         */
        realm.setCredentialsMatcher(matcher);
        realm.setCacheManager(cacheManager);//缓存管理器
        realm.setAuthorizationCache(cacheManager.getCache(realm.getName()));
        return realm;
    }

    /**
     * Shiro的Web过滤器Factory 命名:shiroFilter
     */
    @Bean(name="shiroFilter")
    @SuppressWarnings(value="all")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier(value="securityManager")SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //Shiro的核心安全接口,这个属性是必须的
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("authc", new AjaxPermissionsAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        /*定义shiro过滤链  Map结构
         * Map中key(xml中是指value值)的第一个'/'代表的路径是相对于HttpServletRequest.getContextPath()的值来的
         * anon：它对应的过滤器里面是空的,什么都没做,这里.do和.jsp后面的*表示参数,比方说login.jsp?main这种
         * authc：该过滤器下的页面必须验证后才能访问,它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter
         */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
         /* 过滤链定义，从上向下顺序执行，一般将 / ** 放在最为下边:这是一个坑呢，一不小心代码就不好使了;
          authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问 */
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login/auth", "anon");
        filterChainDefinitionMap.put("/login/logout", "anon");
        filterChainDefinitionMap.put("/error", "anon");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 系统自带的Realm管理，主要针对多realm
     * */
    @Bean(value="modularRealmAuthenticator")
    public ModularRealmAuthenticator modularRealmAuthenticator(@Qualifier(value="sysShiroRealm") SysShiroRealm sysShiroRealm){
        ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        List<Realm> realms = new ArrayList<>();
        //添加多个Realm
        realms.add(sysShiroRealm);
        modularRealmAuthenticator.setRealms(realms);
        return modularRealmAuthenticator;
    }

    /**
    * 初始化cookie信息
     * name 设置 Cookie 名字，默认为 JSESSIONID
     * maxAge 设置 Cookie 的过期时间，秒为单位，默认 - 1 表示关闭浏览器时过期 Cookie；
    * @author      tianjun
    * @date        2019/7/30 14:00
    * @param
    * @return
     */
    @Bean
    public SimpleCookie simpleCookie() {
        SimpleCookie cookie = new SimpleCookie();
        cookie.setName("shiro_redis_session");
        cookie.setMaxAge(-1);
        return cookie;
    }

    /**
    * RedisSessionDAO shiro sessionDAO的实现 通过redis
     * Shiro 提供 SessionDAO 用于会话的 CRUD
     * 使用的是shiro-redis开源插件
    * @author      tianjun
    * @date        2019/7/30 14:04
    * @param
    * @return
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }
    /**
    * 设置shiro会话管理器
    * @author      tianjun
    * @date        2019/7/30 14:06
    * @param
    * @return      
     */
    @Bean
    public SessionManager sessionManager(RedisSessionDAO redisSessionDAO) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO);
        //sessionIdCookie 是 sessionManager 创建会话 Cookie 的模板
        sessionManager.setSessionIdCookie(simpleCookie());
        return sessionManager;
    }

    /**
    * 初始化安全管理器
    * @author      tianjun
    * @date        2019/7/30 14:12
    * @param
    * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(
            @Qualifier(value="modularRealmAuthenticator") ModularRealmAuthenticator modularRealmAuthenticator,
            @Qualifier(value="sysShiroRealm") SysShiroRealm sysShiroRealm,
             SessionManager sessionManager
    ) {
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        //设置realm.
        List<Realm> realms = new ArrayList<>();
        //添加多个Realm
        realms.add(sysShiroRealm);

        dwsm.setRealms(realms);//指定多reamls
        dwsm.setAuthenticator(modularRealmAuthenticator);//针对多realm, 指定认证器
        dwsm.setCacheManager(cacheManager());//指定缓存管理器
        dwsm.setSessionManager(sessionManager);//指定session管理器
        return dwsm;
    }

}
