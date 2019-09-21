package com.spring.security.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.jwt.config.TokenProvider;
import com.spring.security.jwt.dao.UserDao;
import com.spring.security.jwt.dto.AuthToken;
import com.spring.security.jwt.dto.LoginUser;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	

	@Autowired
	private UserDao userDao;

	@Autowired
	private TokenProvider jwtTokenUtil;

	@PostMapping(value = "generatetoken")
	public ResponseEntity<Object> register(@RequestBody LoginUser loginUser)   {
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = jwtTokenUtil.generateToken(authentication);
	
		return ResponseEntity.ok(new AuthToken(token));
	}

	
	
	

}
