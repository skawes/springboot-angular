package com.awes.ems.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.awes.ems.dto.EmployeeDTO;
import com.awes.ems.entity.Employee;
import com.awes.ems.entity.Role;
import com.awes.ems.service.EmployeeService;
import com.awes.ems.service.RoleService;
@Component
public class EmployeeMapper {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RoleService roleService; 

	public EmployeeDTO toEmployeeDTO(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmail(employee.getEmail());
		employeeDTO.setPassword(employee.getPassword());
		employeeDTO.setId(employee.getId());
		employeeDTO.setMobileNo(employee.getMobileNo());
		return employeeDTO;

	}

	public Employee toEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setEmail(employeeDTO.getEmail());
		employee.setPassword(employeeDTO.getPassword());
		employee.setId(employeeDTO.getId());
		employee.setMobileNo(employeeDTO.getMobileNo());
		Set<Role> roles=roleService.findByRoleIdsIn(employeeDTO.getRoleIds()).stream().collect(Collectors.toSet());
		employee.setRoles(roles);
		return employee;

	}

}
