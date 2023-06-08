package com.productapp.entities;

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
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id",nullable = false)
	private Integer id;

	
	@Column(name = "product_name",nullable = false)
	@NotEmpty(message = "{product.name.absent}")
	private String name;
	
	@Column(name = "product_price",nullable = false)
	@NotNull(message = "{product.price.absent}")
	@Range(min=10, max = 10000000, message = "{account.price.invalid}")
	private BigDecimal price;
	
	
	
	@ProductTypeValidation
	@NotEmpty(message = "product type must not be empty")
	@Column(name = "product_type",nullable = false)
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
	
	
	
	
	public Product( String name,BigDecimal price,String productType) {
		super();
		this.name = name;
		this.price = price;
		this.productType = productType;
	}
	public Product() {}	
	
	
	
	
}
