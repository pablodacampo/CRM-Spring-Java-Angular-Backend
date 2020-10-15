package com.pab.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.pab.crm.entity.Company;
import com.pab.crm.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Company> readCompanies() {
		return this.companyRepository.findAll();
	}
	
	public Company createCompany(Company company) {
		return this.companyRepository.save(company);
		
	}
	
	public Company updateCompany(Company company) {
		return this.companyRepository.save(company);
	
	}

	public void  deleteCompany(Long id) {
		this.companyRepository.deleteById(id);
	
	}


}
