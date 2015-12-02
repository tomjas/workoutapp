package com.workout.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.workout.model.User;
import com.workout.utilities.HashPassword;

@Stateless
public class UserService implements UserServiceLocal {

	@PersistenceContext
	private EntityManager em;

	private String username;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User getUserByUsername(String username) {
		this.username = username;
		Query query = em.createNamedQuery("User.getByUsername");
		query.setParameter("username", username);

		@SuppressWarnings("unchecked")
		List<User> usersList = (List<User>) query.getResultList();

		User user;

		if (usersList.isEmpty()) {
			// Potrzebny Null object pattern czy wystarczy zwrócić new User()?
			user = new User();
		} else {
			user = usersList.get(0);
		}

		return user;
	}

	@Override
	public List<User> getAllUsers() {
		Query query = em.createNamedQuery("User.getUsers");
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) query.getResultList();
		return users;
	}

	@Override
	public boolean validateUser(String username, String password) {
		User user = getUserByUsername(username);
		String userPassword = user.getPassword();
		String hashPassword = new HashPassword(password).getHashedPassword();

		if (hashPassword.equals(userPassword)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean registerUser(User user) {
		List<User> users = getAllUsers();

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
