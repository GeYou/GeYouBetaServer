package com.thesis.geyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.geyou.dao.UserDao;
import com.thesis.geyou.entity.User;
import com.thesis.geyou.service.UserService;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public User getUser(Integer id) {

		return userDao.getUser(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getAll(int pNo, int pSize) {
		return userDao.getAll(pNo, pSize);
	}

	@Override
	public User createUser(User u) {
		return userDao.createUser(u);
	}

	@Override
	public int deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}

	@Override
	public boolean checkEmail(String email) {
		if (userDao.getUserByEmail(email) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User checkCredentials(String email, String password) {
		User u = userDao.getUserByEmail(email);
		if (u != null) {
			if (u.getPassword().equals(password)) {
				return u;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public User updateUser(User u) {
		return userDao.updateUser(u);
	}

	@Override
	public User getByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
}