package com.awes.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awes.ems.dto.RoleDTO;
import com.awes.ems.entity.Role;
import com.awes.ems.mapper.RoleMapper;
import com.awes.ems.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleService roleService;
	@PostMapping
	public RoleDTO save(@RequestBody RoleDTO roleDTORequest) {
		Role role=roleMapper.toRole(roleDTORequest);
		RoleDTO roleDTO = roleMapper.toRoleDTO(roleService.save(role));
		if(roleDTO == null)
			roleDTO = new RoleDTO(false,  "Failed to save role");
		else {
			roleDTO.setSuccess(true);
			roleDTO.setMessage("Role saved successfully");
		}
		return roleDTO;
	}
}
