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

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	// COMPANIES

	// getCompanies
	@GetMapping("")
	public List<Company> getCompanies() {
		return this.companyService.getCompanies();
	}

	// getCompanyById
	@GetMapping("/{companyId}")
	public Optional<Company> getCompanyById(@PathVariable Long companyId) {
		return this.companyService.getCompanyById(companyId);
	}
	
	// createCompany
	@PostMapping("/userId/{userId}")
	public Company createCompany(@PathVariable Long userId, @RequestBody Company company) {
		return this.companyService.createCompany(userId, company);
	}
	
	// updateCompany
	@PatchMapping("")
	public Company updateCompany(@RequestBody Company company) {
		return this.companyService.updateCompany(company);
	}	

	// deleteCompany
	@DeleteMapping("/{companyId}")
	public void deleteCompany(@PathVariable Long companyId) {
		this.companyService.deleteCompany(companyId);
	}
	
	// USERS COMPANIES
	
	// getUsersByCompanyId
	@GetMapping("{companyId}/users")
	public Set<User> getUsersByCompanyId(@PathVariable Long companyId) {
		return this.companyService.getUsersByCompanyId(companyId);
	}
	
	// ADDRESSES
	
	// createCompanyAddress
	@PatchMapping("/{companyId}/createaddress")
	public Company createCompanyAddress(@PathVariable Long companyId, @RequestBody Address address) {
		return this.companyService.createCompanyAddress(companyId, address);
	}
	
	// updateCompanyAddress
	@PatchMapping("/{companyId}/updateaddress")
	public Company updateCompanyAddress(@PathVariable Long companyId, @RequestBody Address address) {
		return this.companyService.updateCompanyAddress(companyId, address);
	}
	


}
