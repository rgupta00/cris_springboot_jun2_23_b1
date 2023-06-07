package com.productapp;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
//if want to do something when spring boot strt 
@SpringBootApplication
@EnableAspectJAutoProxy

@EnableScheduling

@EnableCaching
@OpenAPIDefinition
(info = @Info(title = "Product API", version = "2.0" , 
description = "CRIS API"))
public class Productapp02Application implements CommandLineRunner{

	@Autowired
	private ProductDao productDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Productapp02Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		productDao.save(new Product("Laptop", new BigDecimal(78000),"IT"));
		productDao.save(new Product("Laptop cool pad", new BigDecimal(2000),"IT"));
		productDao.save(new Product("Rich dad poor dad", new BigDecimal(2000),"BOOK"));
		System.out.println("--------------------------");
	}

}







