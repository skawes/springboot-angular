package com.awes.ems.service;

import java.util.Collection;
import java.util.List;

import com.awes.ems.entity.Role;

public interface RoleService {

	List<Role> findByRoleIdsIn(Collection<Long> roleIds);

	Role save(Role role);

}
