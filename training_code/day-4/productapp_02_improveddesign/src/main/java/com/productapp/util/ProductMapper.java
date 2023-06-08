package com.productapp.util;

import com.productapp.dto.ProductDto;
import com.productapp.entities.Product;

public class ProductMapper {

	public static ProductDto productToProductDto(Product product) {

		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setProductType(product.getProductType());
		return productDto;
	}

	public static Product productDtoToProduct(ProductDto productDto) {

		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setProductType(productDto.getProductType());
		return product;
	}

}
