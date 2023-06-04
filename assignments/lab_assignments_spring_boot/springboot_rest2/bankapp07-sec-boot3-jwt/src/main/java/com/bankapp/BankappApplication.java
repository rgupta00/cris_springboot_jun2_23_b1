package com.bankapp;

import com.bankapp.entities.Account;
import com.bankapp.entities.UserEntity;
import com.bankapp.service.AccountService;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BankappApplication implements CommandLineRunner {

	@Autowired
	private AccountService accountService;

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//789
		//(String name, BigDecimal balance, String phone, String email)
		accountService.addAccount(new Account("kapil", new BigDecimal(1000), "9845000034","kapil@gmail.com"));
		accountService.addAccount(new Account("sunita", new BigDecimal(1600), "8005000034","sunita@gmail.com"));
		accountService.addAccount(new Account("jack", new BigDecimal(1000), "9895000034","jack@gmail.com"));


		//String username, String password, List<String> roles
//		userService
//				.addUserEntity(new UserEntity("raj","raj123", List.of("ROLE_MGR","ROLE_CLERK")));
//		userService
//				.addUserEntity(new UserEntity("ekta","ekta123", List.of("ROLE_CLERK")));

		userService
				.addUserEntity(new UserEntity("raj",passwordEncoder.encode("raj123"),Arrays.asList("ROLE_MGR","ROLE_CLERK")));
		userService
				.addUserEntity(new UserEntity("ekta",passwordEncoder.encode("ekta123"), Arrays.asList("ROLE_CLERK")));

		UserEntity user=userService.findByUsername("raj");
		System.out.println("------------------------*************-------------------------");
		System.out.println(user.getPassword());
		System.out.printf("---------------------------------");
	}
}
