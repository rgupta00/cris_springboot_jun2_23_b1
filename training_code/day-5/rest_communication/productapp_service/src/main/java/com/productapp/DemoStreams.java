package com.productapp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.productapp.dto.ProductDto;
import com.productapp.entities.Product;
import com.productapp.util.ProductMapper;

public class DemoStreams {

	//How streams works?
	
	public static void main(String[] args) {
		
		//how to convert List<Product> to List<ProductDto>
		
//		Predicate<Product> predicateP1=new Predicate<Product>() {
//
//			@Override
//			public boolean test(Product p) {
//				return p.getProductType().equals("IT");
//			}
//		};
//		
//		
//		Predicate<Product> predicateP1=(Product p)-> {
//				return p.getProductType().equals("IT");
//			
//		};
		
		
//		Predicate<Product> predicateP1=(Product p)-> p.getProductType().equals("IT");
			
		Predicate<Product> predicateP1= p-> p.getProductType().equals("IT");
		
//		
		
		//Function is aka transformer
		
//		Function<Product, ProductDto>function=new Function<Product, ProductDto>() {
//
//			@Override
//			public ProductDto apply(Product p) {
//				return new ProductDto(p.getId(), p.getName(), p.getPrice(), p.getProductType());
//			}
//		};
		
//		
//		Function<Product, ProductDto>function=new Function<Product, ProductDto>() {
//
//			@Override
//			public ProductDto apply(Product p) {
//				return ProductMapper.productToProductDto(p);
//			}
//		};
		
		
		
//		Function<Product, ProductDto>function=(Product p)-> {
//				return ProductMapper.productToProductDto(p);
//			
//		};
		
		
//		Function<Product, ProductDto>function= p->  ProductMapper.productToProductDto(p);
		
	// :: meth.
//		Function<Product, ProductDto>function= ProductMapper::productToProductDto;//*
	
		
		//it itself is not useful i need to put somewhere
		Function<ProductDto, Product>function2= ProductMapper::productDtoToProduct;
		
		
//		//i have list of products i want all all it products
//		
//		List<Product> products=getAll()
//				.stream()
//				.filter(predicateP1)
//				.collect(Collectors.toList());
//		
//			
//		products.forEach(p->System.out.println(p));
//				
		
		
	//i have list of products i want all all it products
		
		List<Product> products=getAll()
				.stream()
				.filter(predicateP1)
				.collect(Collectors.toList());
		
			
		//products.forEach(p->System.out.println(p));
				
		
//		//i have list of products i want all all it products names
//		
//		List<String> listOfProductsName=getAll()
//				.stream()
//				.filter(p->p.getProductType().equals("IT"))
//				.map(p->p.getName())
//				.collect(Collectors.toList());
//		
//				
//		
//		listOfProductsName.forEach(pname-> System.out.println(pname));
		
		
		//i have list of products i want all  it products names to be printed ...
		
//				getAll()
//						.stream()
//						.filter(p->p.getProductType().equals("IT"))
//						.map(m->m.getName())
//						.forEach(name-> System.out.println(name));
				
		
	//what is the diff be -> and :: both are same
		//it is advise to use :: 
				
//		getAll()
//		.stream()
//		.filter(Product::isITProduct)
//		.map(Product::getName)
//		.forEach(name-> System.out.println(name));	
//	
		
		//I want to convert ProdutList to ProductDto list
		
		List<ProductDto> dtos=
				getAll()
				.stream()
				.map(ProductMapper::productToProductDto)
				.collect(Collectors.toList());
		
		
		
		
	}
	
	
	
	public static List<Product> getAll(){
		List<Product> products=new ArrayList<Product>();
		products.add(new Product(1, "laptop", BigDecimal.valueOf(150000), "IT"));
		products.add(new Product(19, "laptop cover", BigDecimal.valueOf(150), "IT"));
		products.add(new Product(16, "Rich dad poor dad", BigDecimal.valueOf(300), "BOOK"));
		
		
		return products;
	}
}
