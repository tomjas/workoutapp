package com.workout.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.workout.model.User;
import com.workout.service.UserServiceLocal;

@ManagedBean(name = "userController")
// @RequestScoped
public class UserController {

	@Inject
	private UserServiceLocal userService;

	@ManagedProperty(value = "#{sessonController}")
	private SessionController sessionController;

	private String username;
	private String password;
	private User user;

	public String login() {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			return "failure";
		}

		if (userService.validateUser(username, password)) {
			return "success";
		}

		return "failure";
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

	public void setSessionController(SessionController sessionController) {
		this.sessionController = sessionController;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
