package com.productapp;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.entity.Product;
import com.productapp.repo.ProductRepository;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//i want to add 1000 products
		
		List<Product> products=
				IntStream.rangeClosed(1, 1000)
				.mapToObj(i-> new Product("product "+ i, new Random().nextInt(100), 
						BigDecimal.valueOf(new Random().nextInt(10000))))
				.collect(Collectors.toList());
		productRepository.saveAll(products);
		
		//200 produts...
//		List<Product> list=IntStream
//				.rangeClosed(1, 200)
//				.mapToObj(i-> new Product("product "+i,
//						new Random().nextInt(100), new Random().nextLong(50000))).collect(Collectors.toList());
		
		//productRepository.saveAll(list);
	}
}





