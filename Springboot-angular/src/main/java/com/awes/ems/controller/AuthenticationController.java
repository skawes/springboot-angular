package com.awes.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awes.ems.dto.EmployeeDTO;
import com.awes.ems.entity.Employee;
import com.awes.ems.mapper.EmployeeMapper;
import com.awes.ems.security.EmployeePrincipal;
import com.awes.ems.security.JwtTokenProvider;
import com.awes.ems.service.EmployeeService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = { "Authentication" })
@RequestMapping("/auth")
public class AuthenticationController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@PostMapping("/login")
	public ResponseEntity<Object> authenticateUser(@RequestBody EmployeeDTO loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		// EmployeePrincipal employeePrincipal = (EmployeePrincipal)
		// authentication.getPrincipal();
		String jwt = tokenProvider.generateToken(authentication);
		if (authentication.getPrincipal() instanceof EmployeePrincipal)
			((EmployeePrincipal) (authentication.getPrincipal())).setJwtToken(jwt);

		return ResponseEntity.ok(authentication.getPrincipal());
	}

	@PostMapping("/signup")
	public EmployeeDTO addEmployee(@RequestBody EmployeeDTO signUpRequest) {
		Employee employee = employeeService.findByEmail(signUpRequest.getEmail());
		if (employee == null) {
			employee = employeeService.save(employeeMapper.toEmployee(signUpRequest));
			EmployeeDTO employeeDTO = employeeMapper.toEmployeeDTO(employee);
			employeeDTO.setSuccess(true);
			employeeDTO.setMessage("Employee saved successfully");
			return employeeDTO;
		}
		return new EmployeeDTO(false, "email already exist");

	}

}
