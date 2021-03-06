package com.pab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pab.crm.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
