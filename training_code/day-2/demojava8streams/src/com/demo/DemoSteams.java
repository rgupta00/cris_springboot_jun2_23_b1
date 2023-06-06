package com.demo;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
public class DemoSteams {
	
	public static void main(String[] args) {
		
		Predicate<Product> predicate=p-> p.getPrice()>=9000;
		
		//find all name of all  products that are pricy, sort
		
		//0-->20%
		
		List<String> names= getAll().stream()
				.filter(p-> p.getPrice()>=9000)
				.map(p-> p.getName())
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		
		names.forEach(name-> System.out.println(name));
		
		
		
		
		
		
		
				
		
		
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		//Some Ex
		
		//i wnat then name of all vendor sort by name
		List<Product> list=getAll();
		
		list.stream().
		map(p-> p.getName())
		.parallel()
		.sorted(Comparator.reverseOrder())
		.forEach(n-> System.out.println(n));
		
		//We wnat to get sum of cost of all products
		
		double cost=list.stream()
				.mapToDouble(p-> p.getPrice())
				.sum();
		
		
//		List<String> names= new ArrayList<String>();
//		
//		for(Product product: list) {
//			names.add(product.getName());
//		}
//		
//		Collections.sort(names,new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return o2.compareTo(o1);
//			}
//			
//		});
//		
//		for(String name: names) {
//			System.out.println(name);
//		}
		
	}
	
	public static List<Product> getAll(){
		
		List<Product> list=new ArrayList<Product>();
		list.add(new Product(1, "laptop", 89000, "Mantra"));
		list.add(new Product(2, "mixer", 8100, "Varun"));
		list.add(new Product(5, "Water header", 39000, "Sunny"));
		list.add(new Product(16, "laptop coolpad", 800, "Mantra"));
		
		
		return list;
	}

}
