package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dao.Product;
import com.productapp.service.ProductService;

@RestController
public class ProductControler {
	
	private ProductService productService;

	@Autowired
	public ProductControler(ProductService productService) {
		this.productService = productService;
	}
	
	//-----getting all products
	
	@GetMapping(path = "products")
	public List<Product> getAll(){
		return productService.getProducts();
	}
	
	//-----getting by id
	@GetMapping(path = "products/{pid}")
	public Product getById(@PathVariable(name = "pid")  int id) {
		return productService.getById(id);
	}
	

}








