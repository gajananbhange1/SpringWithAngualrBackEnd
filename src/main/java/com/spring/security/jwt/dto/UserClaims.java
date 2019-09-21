package com.spring.security.jwt.dto;

import io.jsonwebtoken.Claims;

public class UserClaims {
	public final String id;
	public final String clientName;
	public final String roles;

	@SuppressWarnings("unchecked")
	public UserClaims(Claims claims) {
		this.id = claims.getId();
		this.clientName = claims.getSubject();
		this.roles = (String) claims.get("roles");
	}
	
	
}
