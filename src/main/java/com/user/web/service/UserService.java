 package com.user.web.service;

import java.util.List;

import com.user.web.domain.User;

public interface UserService {

	public User createUser(User user);
	
	public List<User> findAllUsers();

}
