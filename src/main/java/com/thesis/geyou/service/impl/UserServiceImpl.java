package com.thesis.geyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.geyou.dao.UserDao;
import com.thesis.geyou.entities.User;
import com.thesis.geyou.service.UserService;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;
	
	@Override
	public void createUser(User u) {
		userDao.createUser(u);
	}

	public List<User> getAll(int pNo, int pSize){
		return userDao.getAll(pNo, pSize);
	}
	
	@Transactional(readOnly = true)
	@Override
	public User getUser(Integer id) {
		
		return userDao.getUser(id);
	}

	@Override
	public void updateUser(User u) {
		userDao.updateUser(u);
	}

	@Override
	public int deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}

	@Override
	public boolean checkCredentials(String email, String password) {
		User u = userDao.getUserByEmail(email);
		if (u != null) {
			if (u.getEmail().equals(password)){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
