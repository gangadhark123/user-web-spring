package com.user.web.dao;

import java.util.List;

import com.user.web.domain.User;

public interface UserDao {

	public int create(User user);
	
	public List<User> findAllUsers();

}
