package com.pab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pab.crm.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
