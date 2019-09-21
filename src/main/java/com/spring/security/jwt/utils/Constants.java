package com.spring.security.jwt.utils;

public class Constants {

	private Constants() {

	}

	public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 1800;
	public static final long REFRESH_TOKEN_VALIDITY_SECONDS = 2800;
	public static final String SIGNING_KEY = "gajanan123";
	public static final String REFRESH_SIGNING_KEY = "welcome";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String AUTHORITIES_KEY = "scopes";
}
