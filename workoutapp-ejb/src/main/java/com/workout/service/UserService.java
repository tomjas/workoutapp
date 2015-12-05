package com.workout.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.workout.interceptor.Log;
import com.workout.model.User;
import com.workout.model.User.Role;
import com.workout.utility.HashPassword;

@Stateless
@Log
public class UserService implements UserServiceLocal {

	@PersistenceContext
	private EntityManager em;

	private String username;

	public UserService() {
	}

	@Override
	public User getUserByUsername(String username) {
		this.username = username;
		Query query = em.createNamedQuery("User.getByUsername");
		query.setParameter("username", username);

		@SuppressWarnings("unchecked")
		List<User> usersList = (List<User>) query.getResultList();

		User user = null;

		if (!usersList.isEmpty()) {
			user = usersList.get(0);
		}

		return user;
	}

	@Override
	public List<User> getUsers() {
		Query query = em.createNamedQuery("User.getUsers");
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) query.getResultList();
		return users;
	}

	@Override
	public List<User> getUsersByRole(Role role) {
		Query query = em.createNamedQuery("User.getByRole");
		query.setParameter("role", role);
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) query.getResultList();
		return users;
	}

	@Override
	public User validateUser(String username, String password) {
		User user = getUserByUsername(username);
		
		if (user == null) {
			return null;
		}
		
		String userPassword = user.getPassword();
		String hashPassword = new HashPassword(password).getHashedPassword();

		if (hashPassword.equals(userPassword)) {
			return user;
		}

		return null;
	}

	@Override
	public boolean registerUser(User user) {
		List<User> users = getUsers();

		for (User u : users) {
			if (u.getUsername().equals(user.getUsername()) || u.getEmail().equals(user.getEmail())) {
				return false;
			}
		}
		user.setPassword(new HashPassword(user.getPassword()).getHashedPassword());
		em.persist(user);
		return true;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
