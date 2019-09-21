package com.spring.security.jwt.dto;

public class AuthRefreshToken  {
	 private String refreshToken;

	public AuthRefreshToken(String refreshToken) {
		super();
		this.refreshToken = refreshToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	 
	
	 
}
