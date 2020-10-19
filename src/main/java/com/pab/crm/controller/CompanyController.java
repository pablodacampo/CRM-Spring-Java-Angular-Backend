package com.pab.crm.controller;

import java.util.List;
import java.util.Optional;

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

	@GetMapping("/{companyId}")
	public Optional<Company> readCompanyById(@PathVariable Long companyId) {
		return this.companyService.readCompanyById(companyId);
	}

	@PostMapping("")
	public Company createCompany(@RequestBody Company company) {
		return this.companyService.createCompany(company);
	}
	
	@PatchMapping("/{companyId}")
	public Company updateCompany(@PathVariable Long companyId, @RequestBody Company company) {
		return this.companyService.updateCompany(company);
	}
	
	@PatchMapping("/{companyId}/createaddress")
	public Company createCompanyAddress(@PathVariable Long companyId, @RequestBody Address address) {
		return this.companyService.createCompanyAddress(companyId, address);
	}
	
	@PatchMapping("/{companyId}/updateaddress")
	public Company updateCompanyAddress(@PathVariable Long companyId, @RequestBody Address address) {
		return this.companyService.updateCompanyAddress(companyId, address);
	}

	@DeleteMapping("/{companyId}")
	public void deleteCompany(@PathVariable Long companyId) {
		this.companyService.deleteCompany(companyId);
	}

}
