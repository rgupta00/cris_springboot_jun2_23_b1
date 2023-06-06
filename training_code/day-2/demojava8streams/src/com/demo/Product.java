package com.demo;

public class Product {
	private int id;
	private String name;
	private double price;
	private String vendor;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Product(int id, String name, double price, String vendor) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.vendor = vendor;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
