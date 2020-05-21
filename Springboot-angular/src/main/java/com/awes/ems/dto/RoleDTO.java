package com.awes.ems.dto;

import com.awes.ems.enumeration.RoleEnum;

public class RoleDTO extends BaseDTO {

	
	public RoleDTO() {
		super();
	}

	public RoleDTO(Boolean success, String message) {
		super(success, message);
	}

	private Long id;

	private RoleEnum roleName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleEnum getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleEnum roleName) {
		this.roleName = roleName;
	}

}
