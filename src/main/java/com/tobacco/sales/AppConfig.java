package com.tobacco.sales;

import com.tobacco.sales.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author liqingfei
 */
@Configuration
@Import(SecurityConfig.class)
public class AppConfig {

    @Value(value = "${datasource.driver-class-name}")
    private String driverClassName;
    @Value(value = "${datasource.url}")
    private String dbURL;
    @Value(value = "${datasource.username}")
    private String dbUsername;
    @Value(value = "${datasource.password}")
    private String dbPassword;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(dbURL);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

}
