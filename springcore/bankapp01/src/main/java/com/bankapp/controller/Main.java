package com.bankapp.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankapp.config.AppConfig;
import com.bankapp.dao.Account;
import com.bankapp.service.AccountService;
import com.bankapp.service.AccountServiceImpl;

public class Main {

	public static void main(String[] args) {
		//Sping act as a container that manage the dependies
		
		//ApplicationContext vs AnnotationConfigApplicationContext
		//ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bankapp.xml");
		
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		
		AccountService accountService=(AccountService) ctx.getBean("accountService");
		
		List<Account>accounts= accountService.getAll();
		accounts.forEach(a-> System.out.println(a));
		
		accountService.transfer(1, 2, 10);
		
		accounts= accountService.getAll();
		accounts.forEach(a-> System.out.println(a));
		
	}
}
