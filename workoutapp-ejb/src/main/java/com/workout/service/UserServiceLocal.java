package com.workout.service;

import javax.ejb.Local;

import com.workout.model.User;

@Local
public interface UserServiceLocal {

	User getUserByLogin(String login);

}
