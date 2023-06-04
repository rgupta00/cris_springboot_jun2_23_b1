package com.productapp.service;

import com.productapp.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    //all the products sorted as per field
    public List<Product> getAllSortedAsPerField(String fieldName);
    public Page<Product> getAllSortedPagination(int offset, int pageNo);
    public Page<Product> getAllSortedPaginationAndPerField(int offset, int pageNo, String fieldName);

    //all the products offset and pageSize
    //1000          ->20           30

    //all the products offset and pageSize , field

    //all the products
    public List<Product> getAll();


    public Product addProduct(Product product);
    public Product updateProduct(int productId, Product product);
    public Product deleteProduct(int productId);
    public Product getProductById(int productId);

    public List<Product> getAllByName(String productName);

}
