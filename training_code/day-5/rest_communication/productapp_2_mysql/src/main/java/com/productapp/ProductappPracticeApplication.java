package com.productapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ProductappPracticeApplication{


	
	//Autoconfigraution of the bean?
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ProductappPracticeApplication.class, args);
		
//	    System.out.println("Let's inspect the beans provided by Spring Boot:");
//	
//	    String[] beanNames = ctx.getBeanDefinitionNames();
//	    Arrays.sort(beanNames);
//	    for (String beanName : beanNames) {
//	        System.out.println(beanName);
//	    }
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
				System.out.println("hello");
				
				
		};
	}

}







