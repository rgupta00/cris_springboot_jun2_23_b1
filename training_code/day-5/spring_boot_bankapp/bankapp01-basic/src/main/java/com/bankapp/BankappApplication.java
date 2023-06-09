package com.bankapp;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class BankappApplication implements CommandLineRunner {

	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//(String name, BigDecimal balance, String phone, String email)
		accountService.addAccount(new Account("kapil", new BigDecimal(1000), "9845000034","kapil@gmail.com"));
		accountService.addAccount(new Account("sunita", new BigDecimal(1600), "9005000034","sunita@gmail.com"));
		accountService.addAccount(new Account("jack", new BigDecimal(1000), "9895000034","jack@gmail.com"));

		System.out.printf("---------------------------------");
	}
}
