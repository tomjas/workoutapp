package com.workout.controller;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.workout.model.User;
import com.workout.service.UserServiceLocal;
import com.workout.utilities.HashPassword;

@ManagedBean(name = "userController")
public class UserController {

	@Inject
	UserServiceLocal userService;
	
	private String username;
	private String password;
	private User user;

	
	public String login(){
		if (!username.isEmpty()) {
			user = userService.getUserByLogin(username);
		}
		
		if (user != null) {
			String userPassword = user.getPassword();
			String hashPassword = new HashPassword(password).getHashedPassword();
			
			if (StringUtils.isNotEmpty(userPassword) && userPassword.equals(hashPassword)) {
				return "success";
			}
		}
		return "error";
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
