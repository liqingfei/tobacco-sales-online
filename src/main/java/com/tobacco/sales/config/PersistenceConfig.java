package com.tobacco.sales.config;

import com.tobacco.sales.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author liqingfei
 */
public class PersistenceConfig {

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

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate template = new JdbcTemplate();
        return new JdbcTemplate(dataSource());

    }

    @Bean
    public UserDaoImpl userDao() {
        UserDaoImpl dao = new UserDaoImpl();
        return new UserDaoImpl();
    }

}
