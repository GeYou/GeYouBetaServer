package com.thesis.geyou.dao;

import java.util.List;

import com.thesis.geyou.entity.User;

public interface UserDao {

	User getUser(Integer id);

	List<User> getAll(int pNo, int pSize);

	User createUser(User u);

	User updateUser(User u);

	int deleteUser(Integer id);

	User getUserByEmail(String email);

}