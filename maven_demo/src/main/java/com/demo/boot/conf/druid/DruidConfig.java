package com.demo.boot.conf.druid;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Druid监控web配置
 *
 *
 */
@Configuration
public class DruidConfig {

    @Bean
    public ServletRegistrationBean druidServlet() {
        //为了保留 Druid 对 SQL 方面的监控，
        // spring boot默认是不支持servlet的， 提供了一个servlet的注册接口ServletRegistrationBean来主动注册实现
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        // 登录URL http://localhost:8080/druid/login.html
        reg.addUrlMappings("/druid/*");
        // 设置白名单
        reg.addInitParameter("allow", "127.0.0.1");
        // 设置黑名单
        reg.addInitParameter("deny", "");
        // 设置登录查看信息的账号密码.
        reg.addInitParameter("loginUsername", "admin");
        reg.addInitParameter("loginPassword", "admin");
        return reg;
    }

    @Bean
    @SuppressWarnings("all")
    public FilterRegistrationBean filterRegistrationBean() {
        //配置哪些请求Druid会拦截监控
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions",
                "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    @Bean(name="dataSource")
    public static DataSource datasource(
            @Value("${spring.datasource.driver-class-name}") String driver,
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password,
            @Value("${spring.datasource.initialSize}") int initialSize,
            @Value("${spring.datasource.minIdle}") int minIdle,
            @Value("${spring.datasource.maxActive}") int maxActive,
            @Value("${spring.datasource.maxWait}") long maxWait,
            @Value("${spring.datasource.timeBetweenEvictionRunsMillis}") long timeBetweenEvictionRunsMillis,
            @Value("${spring.datasource.minEvictableIdleTimeMillis}") long minEvictableIdleTimeMillis,
            @Value("${spring.datasource.validationQuery}") String validationQuery,
            @Value("${spring.datasource.testWhileIdle}") boolean testWhileIdle,
            @Value("${spring.datasource.testOnBorrow}") boolean testOnBorrow,
            @Value("${spring.datasource.testOnReturn}") boolean testOnReturn,
            @Value("${spring.datasource.poolPreparedStatements}") boolean poolPreparedStatements,
            @Value("${spring.datasource.maxOpenPreparedStatements}") int maxOpenPreparedStatements) {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        List<Filter> filterList=new ArrayList<Filter>();
        filterList.add(wallFilter());
        druidDataSource.setProxyFilters(filterList);//开启wall filter监控sql语句，并允许多条的sql
        try {							            //搭配使用setProxyFilters 设置防火墙，setFilters 设置监控sql
            druidDataSource.setFilters("stat");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }

    @Bean
    public static WallFilter wallFilter(){
        WallFilter wallFilter=new WallFilter();
        wallFilter.setDbType("mysql");
        wallFilter.setConfig(wallConfig());
        return  wallFilter;
    }
    @Bean
    public static WallConfig wallConfig(){
        WallConfig config =new WallConfig();
        config.setMultiStatementAllow(true);//允许一次执行多条语句
        config.setNoneBaseStatementAllow(true);//允许非基本语句的其他语句
        config.setConditionDoubleConstAllow(true);
        config.setStrictSyntaxCheck(false);//是否进行严格的语法检测
        config.setSelectIntoOutfileAllow(true);//SELECT ... INTO OUTFILE 是否允许，这个是mysql注入攻击的常见手段，缺省是禁止的
        return config;
    }

}
