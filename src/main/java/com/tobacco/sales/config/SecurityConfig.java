package com.tobacco.sales.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * @author liqingfei
 */
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
}
