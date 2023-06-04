package com.productapp.controller;

import java.math.BigDecimal;
import java.util.*;
import com.productapp.dao.Product;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;

public class Main {
	public static void main(String[] args) {

		//Get  Service layer from spring framework and print all products
		ProductService productService = new ProductServiceImpl();

	}

}
