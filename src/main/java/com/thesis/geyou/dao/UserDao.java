package com.thesis.geyou.dao;

import java.util.List;

import com.thesis.geyou.entities.User;

public interface UserDao {

	User getUser(Integer id);

	List<User> getAll(int pNo, int pSize);

	User createUser(User u);

	void updateUser(User u);

	int deleteUser(Integer id);

	User getUserByEmail(String email);

}