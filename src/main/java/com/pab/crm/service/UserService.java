package com.pab.crm.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pab.crm.entity.Address;
import com.pab.crm.entity.Company;
import com.pab.crm.entity.User;
import com.pab.crm.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private CompanyService companyService;

	// USERS
	
	// getUsers
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}

	// getUserById
	public Optional<User> getUserById(Long userId) {
		return this.userRepository.findById(userId);
	}

	// createUser
	public User createUser(User user) {
		return this.userRepository.save(user);
	}
	
	// updateUser
	public User updateUser(User user) {
		return this.userRepository.save(user);
	}
	
	// deleteUser
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);

	}
	
	// COMPANIES
	
	// getCompaniesByUserId	
	public Set<Company> getCompaniesByUserId(Long userId) {
		User user = this.getUserById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		return user.getCompanies();
	}

	// addCompanyToUser
	public Company addCompanyToUser(Long userId, Long companyId) {
		User user = this.userService.getUserById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		Company company = this.companyService.getCompanyById(companyId).get();
		user.addCompany(company);
		this.userRepository.save(user);
		return company;
	}
	
	// removeCompanyFromUser
	public Company removeCompanyFromUser(Long userId, Long companyId) {
		User user = this.userService.getUserById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		Company company = this.companyService.getCompanyById(companyId).get();
		user.removeCompany(company);
		this.userRepository.save(user);
		return company;
	}	
	
	// ADDRESSES

	// createUserAddress
	public User createUserAddress(Long userId, Address createAddress) {
		User user = this.getUserById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		user.setAddress(createAddress);
		return this.updateUser(user);
	}	
	
	// updateUserAddress
	public User updateUserAddress(Long userId, Address updateAddress) {
		User user = this.getUserById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		user.setAddress(updateAddress);
		return this.updateUser(user);
	}


}
