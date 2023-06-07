package com.demo;

public class Demo2 {
	
	public static void main(String[] args) {
		System.out.println("hello world debgugging");
		int arr[]= {3,6,7,8,};
		int sum= getSum(arr);
		System.out.println(sum);
	}

	private static int getSum(int[] arr) {
		int s=0;
		for(int i=0;i<arr.length; i++) {
			s=s+arr[i];
		}
		
		s=s+1;
		return s;
	}

}
