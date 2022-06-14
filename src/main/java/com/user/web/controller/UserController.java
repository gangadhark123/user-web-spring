  package com.user.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.web.domain.User;
import com.user.web.serviceimpl.UserServiceImpl;

//@Controller
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	/*
	 * public UserController(UserServiceImpl userServiceImpl) { super();
	 * this.userServiceImpl = userServiceImpl; }
	 */

	@PostMapping(value="/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createUser(@RequestBody User user, ModelMap userModel) {	
		//ModelMap modelMap = new ModelMap();
		userModel.addAttribute("user", user);
		return "user";
	}
	
	@PostMapping(value="/createXML", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public String createUserXML(@RequestBody User user, ModelMap userModel) {	
		//ModelMap modelMap = new ModelMap();
		userModel.addAttribute("user", user);
		return "user";
	}
	
	//@ResponseBody
	@PostMapping(value="/createRest")
	public User createUserRest(@RequestBody User user) {	
		return userServiceImpl.createUser(user);
	}
	
	@GetMapping("/findAllUsers")
	public List<User> findAllUsers(){
		return userServiceImpl.findAllUsers();
		
	}
	
	

}
