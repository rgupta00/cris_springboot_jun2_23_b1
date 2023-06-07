package com.demo.session1.ex4;

import java.util.Optional;

class UserNotFoundEx extends RuntimeException{}

public class DemoOptiional {
	
	public static void main(String[] args) {
		String name="raja";
		Optional<String> nameOpt=Optional.ofNullable(name);
		
		System.out.println(nameOpt.orElseThrow(UserNotFoundEx::new));
		
	}

}
