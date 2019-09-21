package com.spring.security.jwt.service;

import com.spring.security.jwt.dto.UserDto;
import com.spring.security.jwt.model.User;

import java.util.List;

public interface UserService {

	UserDto saveUser(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
}
