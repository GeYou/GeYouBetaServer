package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entity.User;

public interface UserService {

	User getUser(Integer id);

	List<User> getAll();

	User createUser(User u);

	int deleteUser(Integer id);

	boolean checkEmail(String email);

	User checkCredentials(String username, String password);

	User updateUser(User u);
	
	User getByEmail(String email);
}