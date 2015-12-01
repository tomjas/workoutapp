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

	private String login;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User getUserByLogin(String login) {
		this.login = login;
		Query query = em.createNamedQuery("User.getByLogin");
		query.setParameter("login", login);

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
	public boolean validateUser(String username, String password) {
		User user = getUserByLogin(username);
		String userPassword = user.getPassword();
		String hashPassword = new HashPassword(password).getHashedPassword();

		if (hashPassword.equals(userPassword)) {
			return true;
		}

		return false;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
