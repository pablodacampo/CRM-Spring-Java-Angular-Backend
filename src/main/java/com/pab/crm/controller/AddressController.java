package com.pab.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pab.crm.entity.Address;
import com.pab.crm.service.AddressService;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
	
	@Autowired
	private AddressService addressService;

	@GetMapping("")
	public List<Address> readAddresss() {
		return this.addressService.readAddresses();
	}	
	
	@PostMapping("")
	public Address createAddress(@RequestBody Address address) {
		return this.addressService.createAddress(address);
	}
	
	@PutMapping("")
	public Address updateAddress(@RequestBody Address address) {
		return this.addressService.updateAddress(address);
	}

}
