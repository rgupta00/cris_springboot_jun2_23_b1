package com.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
 public class AudianceAspect {
	
	//What is around adv : servlet filter srping sec @PreAuthrized @Secure
	//@Transactional : Around advice
	
	@Around("execution(public String doMagic())")
	public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("before");
		
		Object value= jp.proceed();
		
		System.out.println("afer");
		return null;
	}
	
	
//	//@Before("execution(public void doMagic())")
//	//@After("execution(public void doMagic())")
//	@After("execution(public void doMagic())")
//	public void clapping() {
//		System.out.println("maza aa gaya..");
//	}
	
//	@AfterThrowing(value = "execution(public void doMagic())",throwing = "ex")
//	public void callDrNow(Exception ex) {
//		System.out.println(ex.getMessage());
//		System.out.println("call dr now ");
//	}
}









