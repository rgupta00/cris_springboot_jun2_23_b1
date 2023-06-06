package com.productapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	

	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}


	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	@Override
	public Product getById(int id) {
		return productDao.getById(id);
	}

}
