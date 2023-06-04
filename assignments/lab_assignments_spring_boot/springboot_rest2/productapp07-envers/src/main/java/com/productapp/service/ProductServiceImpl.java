package com.productapp.service;

import com.productapp.entities.Product;
import com.productapp.exceptions.ResourceNotFoundException;
import com.productapp.repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;


    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product addProduct(Product product) {
         productRepo.save(product);
         return product;
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        Product productToUpdate= getProductById(productId);
        productToUpdate.setPrice(product.getPrice());

        productRepo.save(productToUpdate);

        return productToUpdate;
    }

    @Override
    public Product deleteProduct(int productId) {
        Product productToDelete= getProductById(productId);
        productRepo.delete(productToDelete);
        return productToDelete;
    }

    //Java 8 topic
    @Override
    public Product getProductById(int productId) {
        return productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product with id "+ productId+" is not found"));
    }

    @Override
    public List<Product> getAllByName(String productName) {
        return  null;
       // return productRepo.findByName(productName);
    }
}
