package com.productapp.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.metamodel.StaticMetamodel;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
import com.productapp.dto.DataResponseDto;
import com.productapp.service.ProductService;

@RestController
@RequestMapping(path = "productapp")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// get all products

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "products", produces = {MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public List<Product> getAll2() {
		List<Product> products = productService.getProducts();
		return products;
	}

	// @PathVariable vs @RequestPath

	// get an specific product
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "products/{id}")
	public Product getById(@PathVariable int id) {
		return productService.getById(id);
	}
	// Post a product
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(path="products")
	public Product addProduct(@Valid  @RequestBody  Product product) {
		return productService.addProduct(product);
		
	}
	

//	@ResponseStatus(code = HttpStatus.OK)
//	@GetMapping(path = "v2/products")
//	public Map<String, Object> getAll3(){
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("data", productService.getProducts());
//		map.put("status", HttpStatus.OK.toString());
//		map.put("toContact", "cris.info@.com");
//		
//		return map;
//	}
//	
//	@ResponseStatus(code = HttpStatus.OK)
//	@GetMapping(path = "v3/products")
//	public DataResponseDto getAll4(){
//		DataResponseDto dto=new DataResponseDto();
//		dto.setDateTime(LocalDateTime.now());
//		dto.setProducts(productService.getProducts());
//		dto.setStatus(HttpStatus.OK.toString());
//		return dto;
//	}
//	

//	@GetMapping(path = "v1/products")
//	public ResponseEntity<List<Product>> getAll(){
//		return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts());
//	}
//	

}
