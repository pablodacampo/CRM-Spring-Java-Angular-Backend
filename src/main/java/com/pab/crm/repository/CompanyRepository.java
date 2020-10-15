package com.pab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pab.crm.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

}
