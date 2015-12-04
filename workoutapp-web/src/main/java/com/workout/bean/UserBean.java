package com.workout.bean;

import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

import com.workout.model.User;
import com.workout.model.User.Role;
import com.workout.service.UserServiceLocal;

@ManagedBean(name = "userBean")
// TODO ustalić scope
// @RequestScoped
public class UserBean {

	@EJB
	private UserServiceLocal userService;

	@ManagedProperty(value = "#{sessionBean}")
	private SessionBean sessionBean;

	private String username;
	private String password;
	private User user;
	private String firstName;
	private String lastName;
	private String email;
	private List<User> userList;
	private Role role;

	public String login() {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			return "failure";
		}

		User user = userService.validateUser(username, password);

		if (user != null) {
			sessionBean.login(user);
			return "success";
		}

		return "failure";
	}

	public String logout() {
		sessionBean.logout();
		return "login";
	}

	public String register() {

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

	public List<User> userListByRole(String role) {
		for (Role r : Role.values()) {
			if (role.equals(r.name())) {
				this.role = r;
				return userService.getUsersByRole(this.role);
			}
		}
		List<User> emptyList = Collections.emptyList();
		return emptyList;
				
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<User> getUserList() {
		userList = userService.getUsers();
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
