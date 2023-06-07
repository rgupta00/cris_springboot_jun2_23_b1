package com.demo.session1.ex5;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongConsumer;
import java.util.stream.LongStream;


public class DemoParellelStream {
	public static void main(String[] args) {
		
		//500000500000
		long sum=0;
		for(long i=0;i<=1_000_000;i++){
			sum=sum+i;
		}
		
		System.out.println(sum);
		
		//156367086564
		Long sum2[]=new Long[]{0L};
		AtomicLong x=new AtomicLong(0);//CAS vs synch
		
		LongStream.rangeClosed(0, 1_000_000).parallel().forEach(( value)-> x.addAndGet(value));
		
		long sum3=LongStream.rangeClosed(0, 1_000_000).parallel().reduce(0, (a,b)->a+b);
		System.out.println(sum3);
		
		//System.out.println(x);
		//System.out.println(sum2[0]);
		//x->sum2+=x
		//Long sum2[]=new Long[]{0L};
		
	}

}








