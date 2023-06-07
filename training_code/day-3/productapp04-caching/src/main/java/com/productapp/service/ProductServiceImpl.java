package com.productapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
import com.productapp.exceptions.ProductNotFoundException;
@Service
//@Log4j2

//now we have to apply cache to service layer 
//ProductCache
public class ProductServiceImpl implements ProductService{

	private Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);
	
	private ProductDao productDao;
	
	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Cacheable(value ="ProductCache" )
	@Override
	public List<Product> getProducts() {
		long start=System.currentTimeMillis();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		logger.info("*************************getProduct method is being called*************************");
		List<Product> products= productDao.findAll();
		long end=System.currentTimeMillis();
		logger.info("*************************getProduct method is executed : "+ (end-start)+" ms *************************");
		
		return products;
		
	}

	@Cacheable(value="ProductCache", key = "#id")
	@Override
	public Product getById(int id) {
		return productDao.findById(id)
				.orElseThrow(()->new ProductNotFoundException("product with id "+ id +" not found"));
	}

	@Override
	public Product getByName(String name) {
		return productDao.findByName(name);
	}

	@CachePut(value="ProductCache", key="#result.id")
	@Override
	public Product addProduct(Product product) {
			
		return productDao.save(product);
	}

	@CacheEvict(value="ProductCache", key="#id")
	@Override
	public Product deleteProduct(int id) {
		Product productToDelete=getById(id);
		productDao.delete(productToDelete);

		return productToDelete;
	}

	@CachePut(value="ProductCache", key="#result.id")
	@Override
	public Product updateProduct(int id, Product product) {
		Product productToUpdate=getById(id);
		productToUpdate.setPrice(product.getPrice());
		productDao.save(productToUpdate);
		return productToUpdate;
	}

	@CacheEvict(value="ProductCache", allEntries=true)
	@Override
	public void evict() {
		
		System.out.println("*******************************************");
	}

}







