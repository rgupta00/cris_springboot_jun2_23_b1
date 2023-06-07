package com.productapp.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.productapp.dao.Product;

public class DataResponseDto {
	private String status;
	private List<Product> products;
	private LocalDateTime dateTime;
	
	
	public DataResponseDto() {}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
}
