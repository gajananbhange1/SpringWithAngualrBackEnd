package com.spring.security.jwt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleDto {

	@JsonProperty(value = "role")
	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
