package com.spring.security.jwt.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.security.jwt.dao.UserDao;
import com.spring.security.jwt.dto.UserDto;
import com.spring.security.jwt.exception.InvalidUserRoleName;
import com.spring.security.jwt.model.Role;
import com.spring.security.jwt.model.User;
import com.spring.security.jwt.repo.UserRoleRepository;
import com.spring.security.jwt.service.UserService;

@Service(value = "userService")
@PropertySource("classpath:errormessage.properties")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRoles().getName()));

		return authorities;

	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
		return userDao.findById(id).get();
	}

	@Override
	public UserDto saveUser(UserDto user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        String userRole = user.getRoleDto().getName();
		if (userRole.equalsIgnoreCase("Admin") || userRole.equalsIgnoreCase("User")) {
			Role roleName = userRoleRepository.findByName(userRole);
			newUser.setRoles(roleName);
		}
		else {
		throw new InvalidUserRoleName(environment.getProperty("invalid_role_name"));
		}
		userDao.save(newUser);
		return user;
	}
}
