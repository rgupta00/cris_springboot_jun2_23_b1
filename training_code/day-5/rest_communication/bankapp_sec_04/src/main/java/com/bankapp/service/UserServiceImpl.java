package com.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.entities.UserEntity;
import com.bankapp.repo.UserRepo;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserEntity findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public void addUserEntity(UserEntity userEntity) {
		userRepo.save(userEntity);
	}

}
