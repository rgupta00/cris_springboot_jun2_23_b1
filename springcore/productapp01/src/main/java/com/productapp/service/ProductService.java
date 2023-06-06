package com.productapp.service;

import java.util.List;

import com.productapp.dao.Product;

public interface ProductService {
	public List<Product>getProducts();
	public Product getById(int id);
}
