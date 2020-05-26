package com.awes.ems.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.awes.ems.entity.Employee;
import com.awes.ems.repository.EmployeeRepository;
import com.awes.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Employee findById(Long id) {

		Employee employee = employeeRepository.findById(id).orElse(null);
		return employee;
	}

	@Override
	public Employee findByEmail(String email) {
		Employee employee = employeeRepository.findByEmail(email).orElse(null);
		return employee;
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		Employee employeeSaved = employeeRepository.save(employee);
		return employeeSaved;
	}

	

}
