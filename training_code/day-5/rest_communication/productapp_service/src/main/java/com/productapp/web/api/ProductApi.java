package com.productapp.web.api;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.metamodel.StaticMetamodel;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.DataResponseDto;
import com.productapp.dto.ProductDto;
import com.productapp.entities.Product;
import com.productapp.repo.ProductRepo;
import com.productapp.service.ProductService;
import com.productapp.util.ProductMapper;
//........./produtapi/
@RestController// @Controller+ @ResponseBody
@RequestMapping(path = "produtapi")
public class ProductApi {

	private ProductService productService;

	
	@Autowired
	public ProductApi(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(path = "products")
	//@GetMapping(path = "products")
	public List<ProductDto> getAll2(@RequestHeader Map<String, String>headers) {
		headers.forEach((k,v)->System.out.println(k+" : "+ v));
		return productService.getProducts();
	}
	

	@GetMapping(path = "products/{id}")
	public ProductDto getById(@PathVariable(name="id")  int id) {
		return productService.getById(id);
		
		//eturn ProductMapper.productToProductDto(productService.getById(id));
	}
	
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(path = "products")
	public ProductDto addProduct(@Valid   @RequestBody  ProductDto productDto) {
		return productService.addProduct(productDto);
		
		//return ProductMapper.productToProductDto(productService.addProduct(product));
	}
	
//	
//	@PostMapping(path = "products")
//	public ResponseEntity<Product> addProduct(@Valid   @RequestBody  Product product) {
//		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));	
//	}
//	
	@PutMapping(path = "products/{id}")
	public ProductDto updateProduct(@PathVariable(name="id")  int id, @RequestBody   ProductDto productDto) {
		return productService.updateProduct(id, productDto);
	}
	
	@DeleteMapping(path = "products/{id}")
	//@RequestMapping(path = "products/{id}", method = RequestMethod.DELETE)
	public ProductDto deleteProductById(@PathVariable int id) {
		return productService.deleteProduct(id);
	}
	
	///What is the use of RequestParam pagination
}








