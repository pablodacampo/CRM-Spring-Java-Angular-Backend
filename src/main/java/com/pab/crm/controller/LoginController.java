package com.pab.crm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pab.crm.dto.LoginRequest;
import com.pab.crm.entity.User;
import com.pab.crm.service.LoginService;

@CrossOrigin
@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("")
	public Optional<User> findByEmailAndPassword(@RequestBody LoginRequest loginRequest) {
		return this.loginService.findByEmailAndPassword(loginRequest);
	}

}
