package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entities.User;

public interface UserService {
	
	public void createUser(User u);
	
	public List<User> getAll(int pNo, int pSize);
	
	public User getUser(Integer id);
	
	public void updateUser(User u);
	
	public int deleteUser(Integer id);
	
	public boolean checkCredentials(String username, String password);
	
	public boolean checkEmail(String email);
}
