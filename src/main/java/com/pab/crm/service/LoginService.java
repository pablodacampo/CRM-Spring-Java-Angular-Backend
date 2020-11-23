package com.pab.crm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pab.crm.dto.LoginRequest;
import com.pab.crm.entity.User;
import com.pab.crm.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> findByEmailAndPassword(LoginRequest loginRequest) {
		return this.userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
	
		
		
	}

}
