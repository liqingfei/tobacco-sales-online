package com.tobacco.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author liqingfei
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.addListener(HttpSessionEventPublisher.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
