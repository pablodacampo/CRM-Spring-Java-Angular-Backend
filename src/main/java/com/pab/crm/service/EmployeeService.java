package com.pab.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pab.crm.entity.Employee;
import com.pab.crm.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> readEmployees() {
		return this.employeeRepository.findAll();
	}
	
	public Optional<Employee> readEmployeeById(Long id) {
		return this.employeeRepository.findById(id);
	}
	
	public Employee createEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
//	public Employee updateEmployee(Long id, String firstName) {
//		Employee employee = this.readEmployeeById(id).get();
//		employee.setFirstName(firstName);
//		return this.employeeRepository.save(employee);
//	
//	}

	public void deleteEmployee(Long id) {
		this.employeeRepository.deleteById(id);
	
	}

	
	

}
