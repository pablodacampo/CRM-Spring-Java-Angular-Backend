package com.pab.crm.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pab.crm.entity.Address;
import com.pab.crm.entity.Company;
import com.pab.crm.entity.User;
import com.pab.crm.repository.CompanyRepository;
import com.pab.crm.repository.UserRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	// COMPANIES

	// getCompanies
	public List<Company> getCompanies() {
		return this.companyRepository.findAll();
	}
	
	// getCompanyById
	public Optional<Company> getCompanyById(Long companyId) {
		return this.companyRepository.findById(companyId);
	}	
	
	// searchCompaniesByReferenceOrName
	public List<Company> searchCompaniesByReferenceOrName(String term) {
		return this.companyRepository.findByReferenceIgnoreCaseContainingOrNameIgnoreCaseContaining(term, term);
	}
	
	// createCompany
	public Company createCompany(Long userId, Company company) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		Company newCompany = this.companyRepository.save(company);
		user.addCompany(newCompany);
		this.userRepository.save(user);
		return newCompany;
	}
	
	// updateCompany
	public Company updateCompany(Company company) {
		return this.companyRepository.save(company);	
	}
	
	// deleteCompany
	public void deleteCompany(Long companyId) {
		this.companyRepository.deleteById(companyId);	
	}	
	
	// USERS
	
	// getUsersByCompanyId
	public Set<User> getUsersByCompanyId(Long companyId) {
		Company company = this.getCompanyById(companyId).orElseThrow(() -> new RuntimeException("Company not found"));
		return company.getUsers();
	}	
	
	// addUserToCompany
	public User addUserToCompany(Long companyId, Long userId) {
		Company company = this.getCompanyById(companyId).orElseThrow(() -> new RuntimeException("Company not found"));
		User user = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		user.addCompany(company);
		return this.userRepository.save(user);
	}
	
	// removeUserFromCompany
	public User removeUserFromCompany(Long companyId, Long userId) {
		Company company = this.getCompanyById(companyId).orElseThrow(() -> new RuntimeException("Company not found"));
		User user = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		user.removeCompany(company);
		return this.userRepository.save(user);
	}
	
	// ADDRESSES
	
	// createCompanyAddress
	public Company createCompanyAddress(Long companyId, Address createCompanyAddress) {
		Company company = this.getCompanyById(companyId).orElseThrow(() -> new RuntimeException("Company not found"));
		company.setAddress(createCompanyAddress);
		return this.updateCompany(company);
	}	

	// updateCompanyAddress	
	public Company updateCompanyAddress(Long companyId, Address updateCompanyAddress) {
		Company company = this.getCompanyById(companyId).orElseThrow(() -> new RuntimeException("Company not found"));
		company.setAddress(updateCompanyAddress);
		return this.updateCompany(company);
	}



	




}
