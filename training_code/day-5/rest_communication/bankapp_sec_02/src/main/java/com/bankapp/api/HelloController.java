package com.bankapp.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.config.SecUser;
//Bank APP inhouse app
@RestController
public class HelloController {

	//home
	@GetMapping(path = "home")
	public String home() {
		return  "home";
	}
	
	@PreAuthorize("hasAuthority('ROLE_MGR')")
	@GetMapping(path = "mgr")
	//mgr
	public String mgr(@AuthenticationPrincipal  SecUser secUser) {
		System.out.println("---------%%%%%%%%%%%------------------------");
		System.out.println(secUser.getUserEntity().getUsername());
		System.out.println(secUser.getUserEntity().getRoles());
		
		
		return  "mgr";
	}
	
	
	
	
//	@PreAuthorize("hasAuthority('ROLE_MGR')")
//	@GetMapping(path = "mgr")
//	//mgr
//	public String mgr(Principal principal) {
//		System.out.println("-----------------------");
//		System.out.println(principal.getName());
//		return  "mgr";
//	}
//	
	//clerk
	@PreAuthorize("hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
	@GetMapping(path = "clerk")
	public String clerk() {
		return  "clerk";
	}
	
}


