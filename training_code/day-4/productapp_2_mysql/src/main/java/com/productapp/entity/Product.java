package com.productapp.entity;

import java.math.BigDecimal;
//Using hibeante -> ORM framewrok 
//Build on top of jdbc

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "product_table")
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	
	private Integer id;
	
	@Column(name = "product_name")
	private String name;
	
	@Column(name = "product_price")
	private BigDecimal price;
	

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
	
	
	
	
	public Product( String name,
			BigDecimal price,
			String productType) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.productType = productType;
	}
	public Product() {}	
	
	
	
	
}
