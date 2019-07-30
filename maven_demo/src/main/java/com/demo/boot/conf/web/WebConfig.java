package com.demo.boot.conf.web;

import com.demo.auth.AuthVerifyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
    * 鉴权安全验证 spring容器初始化
    * @author      tianjun
    * @date        2019/6/28 13:14
    * @param
    * @return
     */
    @Bean
    public AuthVerifyInterceptor authVerifyInterceptor(){
        return new AuthVerifyInterceptor();
    }

    /**
     * 配置系统资源路径
     * 路径/** 代表路径"classpath:/META-INF/resources/", "classpath:/resources/",
     *                "classpath:/static/", "classpath:/public/"
     * @author      tianjun
     * @date        2019/6/28 13:14
     * @param
     * @return
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
//                .addResourceLocations("file:/apps/var/webapps/"+appName+"-frontend/") //如果资源在项目外部，用该方式添加
        ;
        super.addResourceHandlers(registry);
    }

    /**
    * 添加拦截器
    * @author      tianjun
    * @date        2019/6/28 13:18
    * @param
    * @return      
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authVerifyInterceptor())//注册拦截器
                .addPathPatterns("/api/**")//指定需要拦截的路径
                .excludePathPatterns("/api/web/**");//排除addPathPatterns()配置的路径中的部分路径信息
    }
}
