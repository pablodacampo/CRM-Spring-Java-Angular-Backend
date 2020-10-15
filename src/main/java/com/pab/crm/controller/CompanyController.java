package com.pab.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pab.crm.entity.Company;
import com.pab.crm.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("")
	public List<Company> readCompanies() {
		return this.companyService.readCompanies();
	}	
	
	@PostMapping("")
	public Company createCompany(@RequestBody Company company) {
		return this.companyService.createCompany(company);
	}
	
	@PutMapping("")
	public Company updateCompany(@RequestBody Company company) {
		return this.companyService.updateCompany(company);
	}
	
	@DeleteMapping("")
	public void deleteCompany() {
		this.companyService.deleteCompany(null);
	}

}
