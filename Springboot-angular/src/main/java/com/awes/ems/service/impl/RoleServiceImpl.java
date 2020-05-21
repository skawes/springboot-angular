package com.awes.ems.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awes.ems.entity.Role;
import com.awes.ems.repository.RoleRepository;
import com.awes.ems.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findByRoleIdsIn(Collection<Long> roleIds) {
		List<Role> roles = roleRepository.findByIdIn(roleIds);
		return roles;
	}

	@Override
	public Role save(Role role) {
		Role roleSaved=roleRepository.save(role);
		return roleSaved;
	}

}
