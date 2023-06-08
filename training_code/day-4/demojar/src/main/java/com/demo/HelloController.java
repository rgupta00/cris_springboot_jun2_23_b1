package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${my.info}")
	private String info;
	
	@GetMapping(path = "hello")
	public String hello() {
		return "hello to all  cris chams! "+info;
		
	}
}
