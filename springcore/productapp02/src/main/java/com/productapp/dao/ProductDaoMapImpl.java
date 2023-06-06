package com.productapp.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoMapImpl implements ProductDao {

	@Override
	public List<Product> getProducts() {
		List<Product> products=new ArrayList<Product>();
		products.add(new Product(1, "laptop", new BigDecimal(50000)));
		
		products.add(new Product(2, "laptop cool pad", new BigDecimal(5000)));
		
		
		return products;
	}

	@Override
	public Product getById(int id) {
		return getProducts().stream().filter(p-> p.getId()==id).collect(Collectors.toList()).get(0);
	}

	
}
