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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.impl.UserDao#getUser(java.lang.Integer)
	 */
	@Override
	public User getUser(Integer id) {
		return getByKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.impl.UserDao#getAll(int, int)
	 */
	@Override
	public List<User> getAll(int pNo, int pSize) {
		return getAllEntities(pNo, pSize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.thesis.geyou.dao.impl.UserDao#createUser(com.thesis.geyou.entities.
	 * User)
	 */
	@Override
	public User createUser(User u) {
		Integer id = create(u);
		return getUser(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.thesis.geyou.dao.impl.UserDao#updateUser(com.thesis.geyou.entities.
	 * User)
	 */
	@Override
	public User updateUser(User u) {
		update(u);

		return getUser(u.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.impl.UserDao#deleteUser(java.lang.Integer)
	 */
	@Override
	public int deleteUser(Integer id) {
		return delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.UserDao#getUserByEmail(java.lang.String)
	 */
	@Override
	public User getUserByEmail(String email) {
		Criteria criteria = createEntityCriteria("u");
		criteria.add(Restrictions.eq("u.email", email));
		return (User) criteria.uniqueResult();
	}

}
