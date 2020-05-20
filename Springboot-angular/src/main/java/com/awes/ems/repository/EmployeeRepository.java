package com.awes.ems.repository;

import java.util.Optional;

import com.awes.ems.entity.Employee;

public interface EmployeeRepository extends BaseEMSRepository<Employee, Long> {
	Optional<Employee> findByEmail(String email);

}
