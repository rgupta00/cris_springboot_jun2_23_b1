package com.productapp.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.metamodel.StaticMetamodel;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
import com.productapp.dto.DataResponseDto;
import com.productapp.service.ProductService;

@RestController
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// get all products
	public List<Product> getAll2() {
		List<Product> products = productService.getProducts();
		return products;
	}

	// @PathVariable vs @RequestPath
	// get an specific product
	public Product getById(@PathVariable int id) {
		return productService.getById(id);
	}
	// Post a product
	public Product addProduct(@Valid  @RequestBody  Product product) {
		return productService.addProduct(product);	
	}
	
	//update the product
	public Product updateProduct(@PathVariable int id,   @Valid  @RequestBody  Product product) {
		return productService.updateProduct(id, product);
	}
	
	//delete the product
	
	public Product deleteProductById(@PathVariable int id) {
		return productService.deleteProduct(id);
	}
	
}








