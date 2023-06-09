package com.bankapp.dto;

public class MyResource {

	private String data;
	private String owner;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public MyResource() {}
	public MyResource(String data, String owner) {
		super();
		this.data = data;
		this.owner = owner;
	}
	
	
}
