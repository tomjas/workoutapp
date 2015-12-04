package com.workout.service;

import java.util.List;

import javax.ejb.Local;

import com.workout.model.User;
import com.workout.model.User.Role;

@Local
public interface UserServiceLocal {

	User validateUser(String username, String password);

	boolean registerUser(User user);

	User getUserByUsername(String username);

	List<User> getUsers();

	List<User> getUsersByRole(Role role);

}
