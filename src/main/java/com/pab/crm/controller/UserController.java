package com.pab.crm.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pab.crm.entity.Address;
import com.pab.crm.entity.Company;
import com.pab.crm.entity.User;
import com.pab.crm.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// USERS
	
	// getUsers
	@GetMapping("")
	public List<User> getUsers() {
		return this.userService.getUsers();
	}
	
	// getUserById
	@GetMapping("/{userId}")
	public Optional<User> getUserById(@PathVariable Long userId) {
		return this.userService.getUserById(userId);
	}	
	
	// searchUsersByName
	@GetMapping("/search")
	public List<User> searchUsersbyName(@RequestParam String term) {
		return this.userService.searchUsersByName(term);
	}

	// createUser
	@PostMapping("")
	public User createUser(@RequestBody User user) {
		return this.userService.createUser(user);
	}	
	
	// updateUser
	@PatchMapping("")
	public User updateUser(@RequestBody User user) {
		return this.userService.updateUser(user);
	}
	
	// deleteUser
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		this.userService.deleteUser(userId);
	}	
	
	// USERS COMPANIES
	
	// getCompaniesByUserId
	@GetMapping("/{userId}/companies")
	public Set<Company> getCompaniesByUserId(@PathVariable Long userId) {
		return this.userService.getCompaniesByUserId(userId);
	}

	// addCompanyToUser
	@PostMapping("{userId}/companies/{companyId}")
	public Company addCompanyToUser(@PathVariable Long userId, @PathVariable Long companyId){
		return this.userService.addCompanyToUser(userId, companyId);
	}
	
	// removeCompanyFromUser
	@DeleteMapping("/{userId}/companies/{companyId}")
	public Company removeCompanyFromUser(@PathVariable Long userId, @PathVariable Long companyId) {
		return this.userService.removeCompanyFromUser(userId, companyId);
	}	
	
	// ADDRESSES

	// createUserAddress
	@PostMapping("/{userId}/createaddress")
	public User createUserAddress(@PathVariable Long userId, @RequestBody Address address) {
		return this.userService.createUserAddress(userId, address);
	}	
	
	// updateUserAddress
	@PatchMapping("/{userId}/updateaddress")
	public User updateUserAddress(@PathVariable Long userId, @RequestBody Address address) {
		return this.userService.updateUserAddress(userId, address);
	}	
	

	
}

