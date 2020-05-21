package com.awes.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awes.ems.entity.Employee;
import com.awes.ems.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/{id}")
	public Employee findByUserId(@PathVariable Long id) {
		Employee employee = employeeService.findById(id);
		if (employee == null)
			return null;
		return employee;
	}
}
