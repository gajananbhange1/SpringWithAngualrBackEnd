package com.spring.security.jwt.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.jsonwebtoken.SignatureException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private Environment environment;
	
	@ExceptionHandler(SignatureException.class)
	public final ResponseEntity<Object> handleSignatureException(SignatureException signatureException,
			WebRequest request) {
		return new ResponseEntity<>("invalid", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
		exception.printStackTrace();
		return new ResponseEntity<>("invalid", HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException exception, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		return new ResponseEntity<>("request.method.not.supported", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidUserRoleName.class)
	public final ResponseEntity<Object> handleAllExceptions(InvalidUserRoleName invalidrole, WebRequest request) {
		invalidrole.printStackTrace();
		return new ResponseEntity<>(invalidrole.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}

