package com.productapp.repo;

import com.productapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//U ARE DECLARING THE DAO LAYER :)
@Repository
@Transactional
public interface ProductRepo extends JpaRepository<Product, Integer> {
   // @Query("") JPQL(JPA Persitance Query Language) vs SQL

    @Query("select p from Product p")
    public List<Product> getAllProductXYZ();

    @Query("select p from Product p where p.name=?1 or p.id=?2")
    public List<Product> getAllProductByNameAndId(String name, int id);

    @Query("select p from Product p where p.name=:name")
    public List<Product> getAllProductByNameV2(@Param("name") String name);


    //Yuo can also write the methods that change the state of the db

    //product with id=2 price
    @Modifying
    @Query("update Product p set p.price=?1 where p.id=?2")
    public Integer updateProduct(BigDecimal price, int id);


//    public List<Product> findByName(String name);
//
//    public List<Product> findByNameLike(String name);// % +"laptop" +%
//
//    public List<Product> findByNameContaining(String name);// "laptop"
//
//    public List<Product> findByNameStartingWith(String name);
//
//    public List<Product> findByNameEndingWith(String name);
//
//    public List<Product> findByNameIgnoreCase(String name);
//
//    public List<Product> findByNameIn(List<String> names);
//
//    public List<Product> findByMfgDateAfter(LocalDate date);
//
//    public List<Product> findByMfgDateBefore(LocalDate date);
//
//    public List<Product> findByMfgDateBetween(LocalDate date1, LocalDate date2);

}


















