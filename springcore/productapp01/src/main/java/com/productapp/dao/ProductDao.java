package com.productapp.dao;

import java.util.List;

public interface ProductDao {
	public List<Product>getProducts();
	public Product getById(int id);
}
