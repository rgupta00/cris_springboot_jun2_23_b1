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

import com.productapp.dao.Product;
import com.productapp.service.ProductService;

@RestController
@RequestMapping(path = "productapp")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// -------get all products----------200
	@GetMapping(path = "products")
	// @RequestMapping(path = "products")
	public List<Product> getAll() {
		return productService.getProducts();
	}

	// -------get one product---------200
	@GetMapping(path = "products/{id}")
	public ResponseEntity<Product> getById(@PathVariable(name = "id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
	}

	// -------get product by name----------200

	@GetMapping(path = "productsbyname/{name}")
	public Product getByName(@PathVariable(name = "name") String name) {
		return productService.getByName(name);
	}

	// -------add one product---------- 201
	@PostMapping(path = "products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
	}

	// -------update one product----------200
	@PutMapping(path = "products/{id}")
	public Product updateProduct(@PathVariable(name = "id") int id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

	// -------delete one product----------204
	@DeleteMapping(path = "products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") int id) {
		 productService.deleteProduct(id);
		 
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		 
	}

}




