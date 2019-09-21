package com.spring.security.jwt.exception;

public class InvalidUserRoleName extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7228215414817571530L;
	
	public InvalidUserRoleName(){
		super();
	}

	
	public InvalidUserRoleName(String msg){
		super(msg);
	}
}
