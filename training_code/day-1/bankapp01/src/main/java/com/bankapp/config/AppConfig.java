package com.bankapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * <context:annotation-config/>
	<context:component-scan base-package="com.bankapp"/>
	
 */
@Configuration
@ComponentScan(basePackages = {"com.bankapp"})
public class AppConfig {

}
