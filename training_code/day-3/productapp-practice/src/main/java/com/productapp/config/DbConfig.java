package com.productapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DbConfig {

	@Autowired
	private Environment environment;
	
	
	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUsername(environment.getProperty("spring.datasource.username"));
		ds.setPassword(environment.getProperty("spring.datasource.password"));
		ds.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		ds.setUrl(environment.getProperty("spring.datasource.url"));
		
		return ds;
	}
	
}

