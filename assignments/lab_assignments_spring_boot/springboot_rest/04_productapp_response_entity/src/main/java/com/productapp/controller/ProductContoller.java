package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.entity.Product;
import com.productapp.service.ProductService;

@RestController
@RequestMapping(path = "api")
public class ProductContoller {

	private ProductService productService;

	@Autowired
	public ProductContoller(ProductService productService) {
		this.productService = productService;
	}
	
	//ResponseEntity= Data + status code

	// --------get all products-----------
	@GetMapping(path = "products")
	public ResponseEntity<List<Product>> getAll() {
		return null;
	}

	// --------get one product-----------
	@GetMapping(path = "products/{id}")
	public ResponseEntity<Product> getAnProductById(@PathVariable(name="id") int id) {
		return null;
	}

	// -------add one product-----------
	@PostMapping(path = "products")
	public ResponseEntity<Product> addAnProduct(@RequestBody Product product) {
		return null;
	}
	
	//--------updated an product---------
	@PutMapping(path = "products/{id}")
	public ResponseEntity<Product> updateAnProduct(@PathVariable(name="id")int id,@RequestBody Product product ) {
		return null;
	}
	
	@DeleteMapping(path = "products/{id}")
	public ResponseEntity<Void> deleteAnProduct(@PathVariable(name="id")int id ) {
		 return null;
	}
	
}
