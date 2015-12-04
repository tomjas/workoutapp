package com.workout.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import com.workout.model.User;
import com.workout.service.UserServiceLocal;
import com.workout.utility.SessionManager;

@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UserServiceLocal userService;

	private User user;
	private String username;
	private String password;
	private boolean userLoggedIn;

	public void login(User user) {
		this.user = user;
		userLoggedIn = true;
		SessionManager.setSessionAttribute("username", username);
	}

	public void logout() {
		SessionManager.invalidateSession();
		userLoggedIn = false;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public boolean isUserLoggedIn() {
		return userLoggedIn;
	}

	public void setUserLoggedIn(boolean userLoggedIn) {
		this.userLoggedIn = userLoggedIn;
	}

}
