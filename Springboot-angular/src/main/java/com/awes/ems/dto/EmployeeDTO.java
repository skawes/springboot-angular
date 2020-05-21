package com.awes.ems.dto;

import java.util.Collection;

public class EmployeeDTO extends BaseDTO {

	private Long id;
	private String userName;
	private String email;
	private String mobileNo;
	private String password;
	private Collection<Long> roleIds;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(Boolean success, String message) {
		super(success, message);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Collection<Long> roleIds) {
		this.roleIds = roleIds;
	}
  
	
}
