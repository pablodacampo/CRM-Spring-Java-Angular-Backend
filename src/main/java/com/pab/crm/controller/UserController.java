package com.pab.crm.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pab.crm.entity.Address;
import com.pab.crm.entity.Company;
import com.pab.crm.entity.User;
import com.pab.crm.service.CompanyService;
import com.pab.crm.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;	
	
	@GetMapping("")
	public List<User> readUsers() {
		return this.userService.readUsers();
	}
	
	@GetMapping("/{userId}")
	public Optional<User> readUserById(@PathVariable Long userId) {
		return this.userService.readUserById(userId);
	}	

	@PostMapping("")
	public User createUser(@RequestBody User user) {
		return this.userService.createUser(user);
	}
	
	@PatchMapping("/{userId}")
	public User updateUser(@PathVariable Long userId, @RequestBody User user) {
		return this.userService.updateUser(user);
	}
	
	// User Adding Company to Himself
	@PostMapping("/{userId}/companies")
	public Company addToMyCompanies(@PathVariable Long userId, @RequestBody Company company) {
		// Move to Service
		User user = this.userService.readUserById(userId).get();
		Company newCompany = this.companyService.createCompany(company);
		user.addCompany(newCompany);
		this.userService.updateUser(user);
		return newCompany;
	}
	
	// Delete from my companies
	
	// Manager assigning an existing company to a user
	// @PostMapping("{userId}/companies/assign/{companyId}")
	// get the user, get the company. user.addCompany(company), save user;
	
	@GetMapping("/{userId}/companies")
	public Set<Company> addToMyCompanies(@PathVariable Long userId) {
		User user = this.userService.readUserById(userId).get();
		return user.getCompanies();
	}
	
	@PatchMapping("/{userId}/createaddress")
	public User createUserAddress(@PathVariable Long userId, @RequestBody Address address) {
		return this.userService.createUserAddress(userId, address);
	}	
	
	@PatchMapping("/{userId}/updateaddress")
	public User updateUserAddress(@PathVariable Long userId, @RequestBody Address address) {
		return this.userService.updateUserAddress(userId, address);
	}	
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		this.userService.deleteUser(userId);
	}

	
}

