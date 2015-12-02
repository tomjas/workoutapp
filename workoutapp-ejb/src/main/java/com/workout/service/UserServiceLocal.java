package com.workout.service;

import java.util.List;

import javax.ejb.Local;

import com.workout.model.User;

@Local
public interface UserServiceLocal {

	boolean validateUser(String username, String password);

	boolean registerUser(User user);

	User getUserByUsername(String username);

	List<User> getAllUsers();

}
