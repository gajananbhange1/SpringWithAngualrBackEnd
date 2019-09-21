package com.spring.security.jwt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

	private String username;
	private String password;
	@JsonProperty(value = "email-id")
	private String emailId;
	
	@JsonProperty(value = "user_role")
	private RoleDto roleDto;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public RoleDto getRoleDto() {
		return roleDto;
	}

	public void setRoleDto(RoleDto roleDto) {
		this.roleDto = roleDto;
	}

}
