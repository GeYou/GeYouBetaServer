package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entity.User;

public interface UserService {

	public User getUser(Integer id);

	public List<User> getAll(int pNo, int pSize);

	public User createUser(User u);

	public int deleteUser(Integer id);

	public boolean checkEmail(String email);

	public User checkCredentials(String username, String password);

	public User updateUser(User u);

}
