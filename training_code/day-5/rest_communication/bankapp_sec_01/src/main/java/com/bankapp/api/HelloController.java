package com.bankapp.api;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.MyResource;
//Bank APP inhouse app
@RestController
public class HelloController {

	//home
	@GetMapping(path = "home")
	public String home() {
		return  "home";
	}
	
	
	@GetMapping(path = "mgr")
	//mgr
	public String mgr() {
		return  "mgr";
	}
	
	//clerk
	@GetMapping(path = "clerk")
	public String clerk() {
		return  "clerk";
	}
	
}


