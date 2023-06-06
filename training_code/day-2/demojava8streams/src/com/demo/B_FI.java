package com.demo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class B_FI {

	public static void main(String[] args) {
		
		//Consumer 
		
		Consumer<String> consumer= name-> System.out.println("value of name is "+name);
	


		
		
//		Consumer<String> consumer=(String name)-> {
//					System.out.println("value of name is "+name);
//			
//		};
//		
		
		
		
//		Consumer<String> consumer=new Consumer<String>() {
//
//			@Override
//			public void accept(String name) {
//					System.out.println("value of name is "+name);
//			}
//		};
		
		
		// if name is raj then return true else return false

		Function<Product, Double> function = p -> p.getPrice();

		
		
		Function<Product, Double> function2 =p ->  p.getPrice();

				

//		Function<Product, Double>function2=
//				
//				( p) ->{
//						return p.getPrice();
//					
//				};

//		Function<Product, Double>function2=
//		
//		(Product p) ->{
//				return p.getPrice();
//			
//		};

//			Function<Product, Double>function=
//					
//					new Function<Product, Double>() {
//
//						@Override
//						public Double apply(Product p) {
//							return p.getPrice();
//						}
//					};

		// Predicate<String> predicate= name-> name.contains("raj");

//		Predicate<String> predicate= name-> {
//			return name.contains("raj");
//		
//	};

//		Predicate<String> predicate=(String name)-> {
//				return name.contains("raj");
//			
//		};

//		
//		Predicate<String> predicate=new Predicate<String>() {
//
//			@Override
//			public boolean test(String name) {
//				return name.contains("raj");
//			}
//		};
	}
}
