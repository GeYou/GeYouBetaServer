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
	public UserDao userDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.thesis.geyou.service.UserService#createUser(com.thesis.geyou.entities
	 * .User)
	 */
	@Override
	public void createUser(User u) {
		userDao.createUser(u);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.service.UserService#getAll(int, int)
	 */
	public List<User> getAll(int pNo, int pSize) {
		return userDao.getAll(pNo, pSize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.service.UserService#getUser(java.lang.Integer)
	 */
	@Transactional(readOnly = true)
	@Override
	public User getUser(Integer id) {

		return userDao.getUser(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.thesis.geyou.service.UserService#updateUser(com.thesis.geyou.entities
	 * .User)
	 */
	@Override
	public void updateUser(User u) {
		userDao.updateUser(u);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.service.UserService#deleteUser(java.lang.Integer)
	 */
	@Override
	public int deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.thesis.geyou.service.UserService#checkCredentials(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean checkCredentials(String email, String password) {
		User u = userDao.getUserByEmail(email);
		if (u != null) {
			if (u.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.service.UserService#checkEmail(java.lang.String)
	 */
	@Override
	public boolean checkEmail(String email) {
		if (userDao.getUserByEmail(email) != null) {
			return true;
		} else {
			return false;
		}
	}

}
