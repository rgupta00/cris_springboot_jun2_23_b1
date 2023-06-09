package com.bankapp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bankapp.entities.UserEntity;
import com.bankapp.service.UserService;

@SpringBootApplication
public class BankappSec01Application implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BankappSec01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.addUserEntity(new UserEntity("raj", passwordEncoder.encode("raj123") , Arrays.asList("ROLE_MGR","ROLE_CLERK")));
		userService.addUserEntity(new UserEntity("ekta",passwordEncoder.encode("ekta123"), Arrays.asList("ROLE_CLERK")));
		
		System.out.println("--------------------------");
		UserEntity userEntity1=userService.findByUsername("raj");
		System.out.println(userEntity1);
	}

}
