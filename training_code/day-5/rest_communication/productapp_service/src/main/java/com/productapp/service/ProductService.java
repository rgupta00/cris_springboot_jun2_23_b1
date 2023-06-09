package com.productapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productapp.dto.ProductDto;
import com.productapp.entities.Product;

public interface ProductService {
	
	public List<ProductDto>getProducts();
	
	public ProductDto getById(int id);
	
	public ProductDto getByName(String name);
	
	public ProductDto addProduct(ProductDto product);
	public ProductDto deleteProduct(int id);
	
	public ProductDto updateProduct(int id, ProductDto product);
	
	
}
