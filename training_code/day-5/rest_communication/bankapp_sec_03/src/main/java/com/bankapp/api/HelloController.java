package com.bankapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.config.JwtService;
import com.bankapp.config.SecUser;
import com.bankapp.dto.AuthRequest;

//Bank APP inhouse app
@RestController
public class HelloController {

	@Autowired
	private JwtService jwtService;

	// 4. autowire it go validate the user
	@Autowired
	private AuthenticationManager authenticationManager;

	// 1. give a endpoint to issuce the token
//	@PostMapping(path = "authenticate")
//	public String issueToken(@RequestBody  AuthRequest authRequest) {
//		return jwtService.generateToken(authRequest.getUsername());
//	}
//	

	@PostMapping(path = "authenticate")
	public String issueToken(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUsername());
		} else {
			throw new UsernameNotFoundException("user is invalid");
		}
	}

	// home
	@GetMapping(path = "home")
	public String home() {
		return "home";
	}

	@PreAuthorize("hasAuthority('ROLE_MGR')")
	@GetMapping(path = "mgr")
	// mgr
	public String mgr(@AuthenticationPrincipal SecUser secUser) {
		System.out.println("---------%%%%%%%%%%%------------------------");
		System.out.println(secUser.getUserEntity().getUsername());
		System.out.println(secUser.getUserEntity().getRoles());

		return "mgr";
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
	// clerk
	@PreAuthorize("hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
	@GetMapping(path = "clerk")
	public String clerk() {
		return "clerk";
	}

	// create a endpoint and allow user to acces it and if user is valid issue jwt
	// token him

}
