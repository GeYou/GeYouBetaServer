package com.thesis.geyou.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao<T, PK extends Serializable> {

	@Autowired
	SessionFactory sessionFactory;

	private Class<?> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	protected Session getSession() {
		Session s = sessionFactory.getCurrentSession();
		if (s == null) {
			s = sessionFactory.openSession();
		}
		return s;
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public Integer create(T entity) {
		return (Integer) getSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllEntities() {
		return getSession().createCriteria(persistentClass).list();
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public int delete(PK id) {
		String hql = "DELETE FROM " + persistentClass.getName() + " c where c.id = :id";
		Query q = getSession().createQuery(hql);
		q.setParameter("id", id);
		return q.executeUpdate();
	}

	protected Criteria createEntityCriteria(String alias) {
		return getSession().createCriteria(persistentClass, alias);
	}
}