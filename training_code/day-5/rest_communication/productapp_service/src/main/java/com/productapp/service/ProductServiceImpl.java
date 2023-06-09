package com.productapp.service;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.dto.ProductDto;
import com.productapp.entities.Product;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.ProductRepo;
import com.productapp.util.ProductMapper;
@Service
//@Transactional
public class ProductServiceImpl implements ProductService{

	//@Autowired: can be applied on field , setter and ctr
	
	
	private ProductRepo productRepo; 
	
	@Autowired
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<ProductDto> getProducts() {
		return productRepo.findAll().stream()
				.map(ProductMapper::productToProductDto)
				.collect(toList());
	}

	@Override
	public ProductDto getById(int id) {
		Product product= productRepo.findById(id)
				.orElseThrow(()->new ProductNotFoundException("not found"));
		return ProductMapper.productToProductDto(product);
	}

	@Override
	public ProductDto getByName(String name) {

		return null;
	}

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product productAdded= productRepo.save(ProductMapper.productDtoToProduct(productDto));
		
		return ProductMapper.productToProductDto(productAdded);
	}

	@Override
	public ProductDto deleteProduct(int id) {
		
		Product productDeleted= productRepo.findById(id)
				.orElseThrow(()->new ProductNotFoundException("not found"));
		
		productRepo.delete(productDeleted);
		
		return  ProductMapper.productToProductDto(productDeleted);
	}

	@Override
	public ProductDto updateProduct(int id, ProductDto productDto) {
		Product productUpdate= productRepo.findById(id)
				.orElseThrow(()->new ProductNotFoundException("not found"));
		productUpdate.setPrice(productDto.getPrice());
		
		productRepo.save(productUpdate);
		
		return  ProductMapper.productToProductDto(productUpdate);
	}

}







