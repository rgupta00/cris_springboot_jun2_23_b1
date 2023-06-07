package com.productapp;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
//if want to do something when spring boot strt 
@SpringBootApplication
public class Productapp02Application implements CommandLineRunner{

	@Autowired
	private ProductDao productDao;
	
	public static void main(String[] args) {
		
		SpringApplication.run(Productapp02Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		productDao.save(new Product("Laptop", new BigDecimal(78000)));
		productDao.save(new Product("Laptop cool pad", new BigDecimal(2000)));
		System.out.println("--------------------------");
	}

}
