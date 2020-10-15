package com.pab.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pab.crm.entity.Address;
import com.pab.crm.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public List<Address> readAddresses() {
		return this.addressRepository.findAll();
	}
	
	public Address createAddress(Address address) {
		return this.addressRepository.save(address);
		
	}
	
	public Address updateAddress(Address address) {
		return this.addressRepository.save(address);
	
	}


}
