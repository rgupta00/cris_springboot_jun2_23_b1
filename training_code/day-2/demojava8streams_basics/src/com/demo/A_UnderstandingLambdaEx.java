package com.demo;

public class A_UnderstandingLambdaEx {

	public static void main(String[] args) {
		//Ann inner class vs lambda

		Runnable runnable = () ->System.out.println("some code");
	

		Runnable runnable2 = () ->System.out.println("some job of the threads");
			

		Runnable runnable3 = new Runnable() {

			@Override
			public void run() {
				System.out.println("some job of the threads");
			}
		};
	}

}
