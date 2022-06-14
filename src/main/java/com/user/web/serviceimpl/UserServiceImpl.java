package com.user.web.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.web.daoimpl.UserDaoImpl;
import com.user.web.domain.User;
import com.user.web.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl userDaoImpl;

	/*
	 * public void setUserDaoImpl(UserDaoImpl userDaoImpl) { this.userDaoImpl =
	 * userDaoImpl; }
	 */

	@Override
	public User createUser(User user) {
		Boolean i = userDaoImpl.saveUserByPreparedStatement(user);
		System.out.println("Insert status--->"+i);
		return user;
	}

	@Override
	public List<User> findAllUsers() {		
		return userDaoImpl.findAllUsers();
	}
	
	

}
