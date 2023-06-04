package com.productapp.repo;

import com.productapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//U ARE DECLARING THE DAO LAYER :)
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    public List<Product> findByName(String name);
}
