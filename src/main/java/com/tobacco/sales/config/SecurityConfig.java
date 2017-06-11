package com.tobacco.sales.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.filter.DelegatingFilterProxy;

@ImportResource("classpath:security-context.xml")
public class SecurityConfig {

    @Bean
    public FilterRegistrationBean springSecurityFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("springSecurityFilterChain");
        registrationBean.addUrlPatterns("/**");
        registrationBean.setFilter(new DelegatingFilterProxy());
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }
}
