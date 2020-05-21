package com.awes.ems.dto;

public class BaseDTO {

	protected Boolean success;

	protected String message;

	public BaseDTO() {
		super();
	}

	public BaseDTO(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
