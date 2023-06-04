package com.productapp.api;

import com.productapp.entities.Product;
import com.productapp.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController//@RestController= @Controller+ @ResponseBody -> trigger the json parser jakson
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

   // ResponseEntity= data + status code

    //productsorted?fieldName=price
    @GetMapping(path = "productsorted")
    public ResponseEntity<List<Product>> getAllProductSorted( @RequestParam(name = "fieldName") String fieldName){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.getAllSortedAsPerField(fieldName));
    }

    //productsorted?offset=20&pagesize=10
    @GetMapping(path = "productpage")
    public ResponseEntity<Page<Product>> getAllProductPagination(@RequestParam(name = "offset") int offset,
                                                                 @RequestParam(name = "pagesize") int pagesize){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.getAllSortedPagination(offset, pagesize));
    }

    //productpagesorted?offset=20&pagesize=10&fieldName=price
    @GetMapping(path = "productpagesorted")
    public ResponseEntity<Page<Product>> getAllProductPaginationsorted(
            @RequestParam(name = "offset") int offset,
            @RequestParam(name = "pagesize") int pagesize,
            @RequestParam(name = "fieldName") String fieldName){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.getAllSortedPaginationAndPerField(offset, pagesize, fieldName));
    }




    //-------------getAll products--------------
    @GetMapping(path = "products")
    public ResponseEntity<List<Product>> getAll(){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    //-------------get an product by id--------------
    @GetMapping(path = "products/{productId}")
    public ResponseEntity<Product> getById( @PathVariable int productId ){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(productId));
    }

    //-------------add product--postman -json --> java object ------------
    @PostMapping(path = "products")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody  Product product ){
        return  ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
    }
    //-------------delete product--------------
    @DeleteMapping (path = "products/{productId}")
    public ResponseEntity<Void> deleteProduct( @PathVariable int productId ){
          productService.deleteProduct(productId);
          return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //-------------getAll products by Name--------------
//    @GetMapping(path = "products/{name}")
//    public List<Product> getAllByName( @PathVariable String name){
//        return  productService.getAllByName(name);
//    }
    //-------------update product--------------
    @PutMapping (path = "products/{productId}")
    public ResponseEntity<Product> udpateProduct( @PathVariable int productId ,@RequestBody  Product product){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(productId, product));
    }

}



















