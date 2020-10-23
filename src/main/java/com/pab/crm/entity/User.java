package com.pab.crm.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Users")
public class User implements Serializable {
	
	private static final long serialVersionUID = -1711112695555661590L;
	
	@Column
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@Column(length = 20)
	private String firstName;
	
	@Column(length = 15)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(length = 20)
	private String telephone;
	
	@Column(length = 10)
	private String role;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	Set<Company> companies = new HashSet<>();
	
	
	public User() {
		
	}	
	
	public void addCompany(Company company) {
		if (!this.companies.contains(company)) {
			this.companies.add(company);
			company.users.add(this);
		}
	}
	
	public void removeCompany(Company company) {
		if (this.companies.contains(company)) {
			this.companies.remove(company);
			company.users.remove(this);
		}
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}	
	
	
}
