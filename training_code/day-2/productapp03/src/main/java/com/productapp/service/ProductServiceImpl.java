package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
import com.productapp.exceptions.ProductNotFoundException;
@Service
public class ProductServiceImpl implements ProductService{

	private ProductDao productDao;
	
	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getProducts() {
		return productDao.findAll();
	}

	@Override
	public Product getById(int id) {
		return productDao.findById(id)
				.orElseThrow(()->new ProductNotFoundException("product with id "+ id +" not found"));
	}

	@Override
	public Product getByName(String name) {
		return productDao.findByName(name);
	}

	@Override
	public Product addProduct(Product product) {
			productDao.save(product);
		return null;
	}

	@Override
	public Product deleteProduct(int id) {
		Product productToDelete=getById(id);
		productDao.delete(productToDelete);

		return productToDelete;
	}

	@Override
	public Product updateProduct(int id, Product product) {
		Product productToUpdate=getById(id);
		productToUpdate.setPrice(product.getPrice());
		productDao.save(productToUpdate);
		return productToUpdate;
	}

}







