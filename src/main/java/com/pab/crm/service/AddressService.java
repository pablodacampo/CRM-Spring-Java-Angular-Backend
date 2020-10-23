package com.pab.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pab.crm.entity.Address;
import com.pab.crm.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	// ADDRESSES

	// getAddresses
	public List<Address> getAddresses() {
		return this.addressRepository.findAll();
	}
	
	// getAddressById
	public Optional<Address> getAddressById(Long id) {
		return this.addressRepository.findById(id);
	}
	
	// createAddress
	public Address createAddress(Address address) {
		return this.addressRepository.save(address);		
	}
	
	// updateAddress
	public Address updateAddress(Address address) {
		return this.addressRepository.save(address);	
	}


}
