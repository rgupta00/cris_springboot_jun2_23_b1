package com.bankapp.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.entities.UserEntity;
import com.bankapp.service.UserService;

@Service
public class MyDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userService.findByUsername(username);
		if (userEntity == null)
			throw new UsernameNotFoundException("user is invalide");

		// now u have to covert userEntity to the user that spring sec understand

		// AuthorityUtils.creat
	

		return new SecUser(userEntity);
	}

}
