package com.productapp.repo;

import com.productapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//U ARE DECLARING THE DAO LAYER :)
@Repository
@Transactional
public interface ProductRepo
        extends RevisionRepository<Product, Integer, Integer>, JpaRepository<Product, Integer> {

}


















