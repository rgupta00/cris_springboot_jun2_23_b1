package com.productapp.service;

import com.productapp.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {


    public List<Product> getAll();

    public Product addProduct(Product product);
    public Product updateProduct(int productId, Product product);
    public Product deleteProduct(int productId);
    public Product getProductById(int productId);

    public List<Product> getAllByName(String productName);

}
