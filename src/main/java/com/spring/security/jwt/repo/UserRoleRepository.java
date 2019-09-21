package com.spring.security.jwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.jwt.model.Role;

public interface UserRoleRepository extends JpaRepository<Role, Long> {

	
     Role findByName(String rolename);
}
