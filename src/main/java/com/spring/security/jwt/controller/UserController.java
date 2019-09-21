package com.spring.security.jwt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.security.jwt.dto.UserDto;
import com.spring.security.jwt.model.User;
import com.spring.security.jwt.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

  
    @PreAuthorize("hasRole('ADMIN')") 
    @GetMapping(value = "/users")
    public List<User> listUser(){
        return userService.findAll();
    }


    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping(value = "/users/{id}")
    public User getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    @PreAuthorize("hasRole('ADMIN')") 
    @PostMapping(value = "/signup")
    public UserDto saveUser(@RequestBody UserDto user){
        return userService.saveUser(user);
    }



}
