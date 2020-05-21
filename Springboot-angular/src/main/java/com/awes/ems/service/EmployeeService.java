package com.awes.ems.service;

import java.util.Collection;
import java.util.List;

import com.awes.ems.entity.Employee;
import com.awes.ems.entity.Role;

public interface EmployeeService {

	Employee findById(Long id);

	Employee findByEmail(String email);

	Employee save(Employee employee);


}
