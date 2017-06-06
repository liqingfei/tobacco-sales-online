package com.tobacco.sales;

import com.tobacco.sales.config.PersistenceConfig;
import com.tobacco.sales.config.SecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SecurityConfig.class, PersistenceConfig.class})
public class AppConfig {


}
