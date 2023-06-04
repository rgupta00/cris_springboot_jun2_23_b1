package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.dao.ProductDao;
import com.productapp.entity.Product;
import com.productapp.exceptions.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAll() {
		return null;
	}

	@Override
	public Product getById(Integer id) {
		return null;
	}

	@Override
	public Product addProduct(Product product) {
		return null;
	}

	@Override
	public Product deleteProduct(Integer id) {
	
		return null;
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		
		return null;
	}

}
