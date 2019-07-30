package com.demo.boot.conf.web.view;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * JSP试图解析
 */
@Configuration
public class JspViewResolverConfig {

    @Bean
    public FilterRegistrationBean encodingFilterRegistration() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        FilterRegistrationBean registration = new FilterRegistrationBean(encodingFilter);
        registration.setName("encodingFilter");
        registration.addUrlPatterns("/*");
        registration.setAsyncSupported(true);
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setRequestContextAttribute("request");
        return resolver;
    }

}
