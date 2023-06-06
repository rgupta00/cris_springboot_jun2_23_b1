package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	@GetMapping(path = "products")
	//@RequestMapping(path = "products")
	public List<Product> getAll(){
		return productService.getProducts();
	}
	
	@GetMapping(path = "products/{id}")
	public Product getById(@PathVariable(name="id")  int id) {
		return productService.getById(id);
	}
	

}





