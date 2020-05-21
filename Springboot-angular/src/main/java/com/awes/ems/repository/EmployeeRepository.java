package com.awes.ems.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.awes.ems.entity.Employee;
import com.awes.ems.entity.Role;

public interface EmployeeRepository extends BaseEMSRepository<Employee, Long> {
	Optional<Employee> findByEmail(String email);

	

}
