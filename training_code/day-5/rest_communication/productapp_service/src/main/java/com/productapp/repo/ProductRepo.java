package com.productapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.entities.Product;

//@Repository vs @Component *Imp
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	public Product findByName(String name);
}
