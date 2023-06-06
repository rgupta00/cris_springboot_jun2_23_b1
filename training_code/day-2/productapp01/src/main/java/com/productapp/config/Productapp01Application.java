package com.productapp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.productapp"})
public class Productapp01Application {

	public static void main(String[] args) {
		SpringApplication.run(Productapp01Application.class, args);
	}

}
