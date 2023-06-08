package com.productapp.dto;

import java.math.BigDecimal;
//Using hibeante -> ORM framewrok 
//Build on top of jdbc

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.productapp.validation.ProductTypeValidation;
//SRP

public class ProductDto {

	private Integer id;

	
	@NotEmpty(message = "{productDto.name.absent}")
	private String name;
	
	@NotNull(message = "{productDto.price.absent}")
	@Range(min=10, max = 10000000, message = "{productDto.price.invalid}")
	private BigDecimal price;
	
	
	@ProductTypeValidation
	@NotEmpty(message = "product type must not be empty")
	private String productType;
	
	
	
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	
	public ProductDto( String name,BigDecimal price,String productType) {
		super();
		this.name = name;
		this.price = price;
		this.productType = productType;
	}
	public ProductDto() {}	
	
	
	
	
}
