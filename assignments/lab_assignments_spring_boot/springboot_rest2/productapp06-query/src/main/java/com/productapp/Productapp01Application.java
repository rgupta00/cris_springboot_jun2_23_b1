package com.productapp;

import com.productapp.dto.ProductDto;
import com.productapp.entities.Product;
import com.productapp.repo.ProductRepo;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

//IF U WANT TO CONFIGURE UR OWN DATASOURCE ==> THIS U NEED TO DO
@SpringBootApplication
public class Productapp01Application {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(Productapp01Application.class, args);
	}


	@Bean
	public CommandLineRunner runner(){

		return (arg)->{
			//init
			init();

			// public List<Product> findByNameLike(String name);
//			List<Product> products=productRepo.getAllProductXYZ();
//			products.forEach(p-> System.out.println(p));

			List<Product> products=productRepo.getAllProductByNameAndId("dell laptop",2);
			products.forEach(p-> System.out.println(p));

			System.out.println(productRepo.updateProduct( new BigDecimal(2600),2));

			System.out.println(productRepo.findById(2).orElseThrow(()-> new RuntimeException("product not found")));
			// public List<Product> findByNameIn(List<String> names);
//			List<Product> products=productRepo.findByNameIn(List.of("dell laptop","laptop Mouse"));
//			products.forEach(p-> System.out.println(p));

			//public List<Product> findByMfgDateBetween(LocalDate date1, LocalDate date2);
//			List<Product> products=productRepo.findByMfgDateBetween(LocalDate.of(2021, Month.JANUARY, 21),
//					LocalDate.now());
//
//			products.forEach(p-> System.out.println(p));

		};



	}
	private void init(){
		productService.addProduct(new Product("dell laptop", new BigDecimal(120000),
				LocalDate.of(2020, Month.MAY, 20)));

		productService.addProduct(new Product("laptop stand", new BigDecimal(1600),
				LocalDate.of(2021, Month.NOVEMBER, 12)));

		productService.addProduct(new Product("laptop Mouse", new BigDecimal(1800),
				LocalDate.of(2022, Month.FEBRUARY, 17)));
	}

}















