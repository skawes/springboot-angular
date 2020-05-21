package com.awes.ems.mapper;

import org.springframework.stereotype.Component;

import com.awes.ems.dto.RoleDTO;
import com.awes.ems.entity.Role;

@Component
public class RoleMapper {
	public RoleDTO toRoleDTO(Role role) {
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(role.getId());
		roleDTO.setRoleName(role.getRoleName());
		return roleDTO;
	}

	public Role toRole(RoleDTO roleDTO) {
		Role role = new Role();
		role.setId(roleDTO.getId());
		role.setRoleName(roleDTO.getRoleName());
		return role;
	}

}
