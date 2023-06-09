package com.bankapp.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.bankapp.entities.UserEntity;

public class SecUser implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private UserEntity userEntity;
	

	
	public UserEntity getUserEntity() {
		return userEntity;
	}

	public SecUser(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<String> roles= userEntity.getRoles();
		
		String[]rolesArray=roles.toArray(new String[roles.size()]);
		
		//AuthorityUtils.creat
		return AuthorityUtils.createAuthorityList(rolesArray);
	}

	@Override
	public String getPassword() {
		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {
		return userEntity.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
