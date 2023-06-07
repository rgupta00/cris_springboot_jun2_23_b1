package com.demo;
class Emp{
	private int id;
	private String name;
	private double salary;
	
	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}


	public void print() {
		System.out.println("id "+ id +" name "+ name+" salary: "+ salary);
	}
}

class PartTimeEmp extends Emp{
	private int noOfDays;
	private int payPerDay;
	
	public PartTimeEmp(int id, String name, double salary, int noOfDays, int payPerDay) {
		super(id, name, salary);
		this.noOfDays = noOfDays;
		this.payPerDay = payPerDay;
	}
	
	public void print() {
		System.out.println("noOfDays "+ noOfDays +" payPerDay "+ payPerDay);
	}
	
}

public class Demo3 {
	
	public static void main(String[] args) {
		Emp e=new PartTimeEmp(1, "raj", 30000, 21, 17000);
		e.print();
	}

}





