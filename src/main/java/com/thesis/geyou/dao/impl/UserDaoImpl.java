package com.thesis.geyou.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.thesis.geyou.dao.AbstractDao;
import com.thesis.geyou.dao.UserDao;
import com.thesis.geyou.entity.User;

@Repository(value = "userDao")
public class UserDaoImpl extends AbstractDao<User, Integer> implements UserDao {

	@Override
	public User getUser(Integer id) {
		return getByKey(id);
	}

	@Override
	public List<User> getAll(int pNo, int pSize) {
		return getAllEntities(pNo, pSize);
	}

	@Override
	public User createUser(User u) {
		Integer id = create(u);
		return getUser(id);
	}

	@Override
	public int deleteUser(Integer id) {
		return delete(id);
	}

	@Override
	public User getUserByEmail(String email) {
		Criteria criteria = createEntityCriteria("u");
		criteria.add(Restrictions.eq("u.email", email));
		return (User) criteria.uniqueResult();
	}

	@Override
	public User updateUser(User u) {
		update(u);

		return getUser(u.getId());
	}
}