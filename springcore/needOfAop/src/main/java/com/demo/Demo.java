package com.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AppConfig;

public class Demo {
	
	public static void main(String[] args) {
		//When M showing the magic then au should do clapping
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		Magician magician=ctx.getBean("magician",Magician.class);
		
		String data= magician.doMagic();
		
		
		System.out.println(data);
		
	}

}
