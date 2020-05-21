package com.awes.ems.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.awes.ems.entity.Employee;
import com.awes.ems.repository.EmployeeRepository;

@Service
public class CustomEmployeeDetailsService implements UserDetailsService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Employee not found"));
		return EmployeePrincipal.create(employee);
	}

	// This method is used by JWTAuthenticationFilter
	@Transactional
	public EmployeePrincipal loadUserById(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));
		return EmployeePrincipal.create(employee);
	}

}
