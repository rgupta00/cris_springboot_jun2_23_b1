package com.productapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productapp.entities.Product;

public interface ProductService {
	public List<Product>getProducts();
	
	public Product getById(int id);
	
	public Product getByName(String name);
	
	public Product addProduct(Product product);
	public Product deleteProduct(int id);
	
	public Product updateProduct(int id, Product product);
	
	
}
