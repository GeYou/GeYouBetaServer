package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entity.User;

public interface UserService {

	public User createUser(User u);

	public List<User> getAll(int pNo, int pSize);

	public User getUser(Integer id);

	public void updateUser(User u);

	public int deleteUser(Integer id);

	public User checkCredentials(String username, String password);

	public boolean checkEmail(String email);
}
