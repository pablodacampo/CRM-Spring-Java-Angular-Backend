package com.pab.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pab.crm.entity.Address;
import com.pab.crm.entity.User;
import com.pab.crm.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> readUsers() {
		return this.userRepository.findAll();
	}
	
	public Optional<User> readUserById(Long userId) {
		return this.userRepository.findById(userId);
	}
	
	
//	public User updateUser(User updateUser) {
//	User user = this.readUserById(updateUser.getId()).get();
//	user.setFirstName(updateUser.getFirstName());
//	user.setLastName(updateUser.getLastName());
//	user.setEmail(updateUser.getEmail());
//	user.setPassword(updateUser.getPassword());
//	user.setTelephone(updateUser.getTelephone());
//	user.setRole(updateUser.getRole());
//	
//	return this.UserRepository.save(User);
//
//}
	
	public User createUser(User user) {
		return this.userRepository.save(user);
	}
	
	public User createUserAddress(Long userId, Address createAddress) {
		User user = this.readUserById(userId).get();
		user.setAddress(createAddress);
		return this.updateUser(user);
	}
	
	public User updateUser(User user) {
		return this.userRepository.save(user);
	}
	
	public User updateUserAddress(Long userId, Address updateAddress) {
		User user = this.readUserById(userId).get();
		user.setAddress(updateAddress);
		return this.updateUser(user);
	}

	public void deleteUser(Long userId) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		this.userRepository.deleteById(userId);
	
	}	


 //
	
	

}
