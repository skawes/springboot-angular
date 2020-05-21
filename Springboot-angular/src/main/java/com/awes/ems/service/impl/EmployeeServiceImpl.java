package com.awes.ems.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awes.ems.entity.Employee;
import com.awes.ems.entity.Role;
import com.awes.ems.repository.EmployeeRepository;
import com.awes.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

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
	public Employee save(Employee employee) {
		Employee employeeSaved = employeeRepository.save(employee);
		return employeeSaved;
	}

	

}
