package com.pab.crm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Companies")
public class Company implements Serializable {
	
	private static final long serialVersionUID = -7491177392966033658L;
	
	@Column
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long companyId;
	
	@Column(length = 10)
	private String reference;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 30)
	private String owner;
	
	@Column(length = 20)
	private String telephone;
	
	@Column(length = 50)
	private String website;
	
	@Column(length = 30)
	private String contactName;
	
	@Column(length = 20)
	private String contactTelephone;
	
	@Column(nullable = false, unique = true)
	private String contactEmail;
	
	@Column
	private Date callLast;
	
	@Column
	private Date visitLast;
	
	@Column(length = 555)
	private String messages;
	
	@Column(length = 30)
	private String discount;
	
	@Column(length = 50)
	private float salesExp;
	
	@Column(length = 20)
	private float sales3m;
	
	@Column(length = 20)
	private float salesTotal;
	
	@ManyToMany(mappedBy = "companies")
	Set<User> users = new HashSet<>();
	
	@OneToOne
	private Address address;
	
	public Company() {}	
		
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTelephone() {
		return contactTelephone;
	}

	public void setContactTelephone(String contactTelephone) {
		this.contactTelephone = contactTelephone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Date getCallLast() {
		return callLast;
	}

	public void setCallLast(Date callLast) {
		this.callLast = callLast;
	}

	public Date getVisitLast() {
		return visitLast;
	}

	public void setVisitLast(Date visitLast) {
		this.visitLast = visitLast;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public float getSalesExp() {
		return salesExp;
	}

	public void setSalesExp(float salesExp) {
		this.salesExp = salesExp;
	}

	public float getSales3m() {
		return sales3m;
	}

	public void setSales3m(float sales3m) {
		this.sales3m = sales3m;
	}

	public float getSalesTotal() {
		return salesTotal;
	}

	public void setSalesTotal(float salesTotal) {
		this.salesTotal = salesTotal;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	

}
