package com.demo;

import java.util.Scanner;

public class Demo1 {
	
	public void sayHello(String name) {
		System.out.println("Demo1.sayHello(String name) ");
		
		for(int i=0;i<=10;i++) {
			System.out.println("name "+ i);
		}
		System.out.println("end of sayHello");
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter message");
		String msg=scanner.nextLine();
		displayMessage(msg);
	}
	
	
	 void displayMessage(String msg) {
		System.out.println("Demo1.displayMessage method "+ msg);
		System.out.println("Demo1.displayMessage method 2nd time"+ msg);
		
		printNumber(10);
	}


	 void printNumber(int n) {
		System.out.println("Demo1.printNumber");
		for(int i=0;i<=n;i++) {
			System.out.println(i);
		}
		System.out.println("end");
	}

	 public int add(int a, int b) {
		 System.out.println("Demo1.add()");
		 return a+b;
	 }
	 public int sub(int a, int b) {
		 System.out.println("Demo1.sub()");
		 return a-b;
	 }

	public static void main(String[] args) {
		Demo1 demo=new Demo1();
		demo.sayHello("raj");
		demo.add(2, 2);
		demo.sub(2, 3);
	}

}
