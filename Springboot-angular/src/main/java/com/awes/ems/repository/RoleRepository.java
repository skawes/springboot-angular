package com.awes.ems.repository;

import java.util.Collection;
import java.util.List;

import com.awes.ems.entity.Role;


public interface RoleRepository extends BaseEMSRepository<Role, Long> {

	List<Role> findByIdIn(Collection<Long> roleIds);

}
