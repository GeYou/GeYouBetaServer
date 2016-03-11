package com.thesis.geyou.dao;

import java.util.List;

import com.thesis.geyou.entity.User;

public interface UserDao {

	User getUser(Integer id);

	List<User> getAll();

	User createUser(User u);

	int deleteUser(Integer id);

	User getUserByEmail(String email);

	User updateUser(User u);
}