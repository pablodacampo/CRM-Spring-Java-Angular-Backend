package com.pab.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pab.crm.entity.Address;
import com.pab.crm.entity.Company;
import com.pab.crm.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Company> readCompanies() {
		return this.companyRepository.findAll();
	}
	
	public Optional<Company> readCompanyById(Long companyId) {
		return this.companyRepository.findById(companyId);
	}
	
	public Company createCompany(Company company) {
		return this.companyRepository.save(company);
		
	}
	
	public Company createCompanyAddress(Long companyId, Address createCompanyAddress) {
		Company company = this.readCompanyById(companyId).get();
		company.setAddress(createCompanyAddress);
		return this.updateCompany(company);
	}
	
	
	public Company updateCompany(Company company) {
		return this.companyRepository.save(company);
	
	}
	
	public Company updateCompanyAddress(Long companyId, Address updateCompanyAddress) {
		Company company = this.readCompanyById(companyId).get();
		company.setAddress(updateCompanyAddress);
		return this.updateCompany(company);
	}


	public void deleteCompany(Long companyId) {
		this.readCompanyById(companyId).orElseThrow(() -> new RuntimeException("Company not found"));
		this.companyRepository.deleteById(companyId);
	
	}	


}
