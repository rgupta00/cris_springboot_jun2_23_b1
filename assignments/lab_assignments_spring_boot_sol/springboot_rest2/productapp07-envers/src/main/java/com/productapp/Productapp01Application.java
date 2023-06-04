package com.productapp;

import com.productapp.config.ProductAuditor;
import com.productapp.dto.ProductDto;
import com.productapp.entities.Product;
import com.productapp.repo.ProductRepo;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

//IF U WANT TO CONFIGURE UR OWN DATASOURCE ==> THIS U NEED TO DO
//step 5. Enable
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
@EnableJpaAuditing(auditorAwareRef = "productAuditor")
@SpringBootApplication
public class Productapp01Application {


	//3. register it AuditorAware
	@Bean
	public AuditorAware<String> productAuditor(){
		return  new ProductAuditor();
	}

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















