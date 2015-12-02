package com.workout.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.workout.model.User;
import com.workout.service.UserServiceLocal;

@ManagedBean(name = "userBean")
// @RequestScoped
public class UserBean {

	@Inject
	private UserServiceLocal userService;

	@ManagedProperty(value = "#{sessonBean}")
	private SessionBean sessionBean;

	private String username;
	private String password;
	private User user;
	private String firstName;
	private String lastName;
	private String email;

	public String login() {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			return "failure";
		}

		if (userService.validateUser(username, password)) {
			return "success";
		}

		return "failure";
	}
	
	public String register(){
		
		user = new User();
		user.setUsername(username);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);		
		
		if (userService.registerUser(user)) {
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

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
