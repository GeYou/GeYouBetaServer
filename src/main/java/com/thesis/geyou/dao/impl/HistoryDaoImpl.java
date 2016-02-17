/**
 * 
 */
package com.thesis.geyou.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.thesis.geyou.dao.AbstractDao;
import com.thesis.geyou.dao.HistoryDao;
import com.thesis.geyou.entity.History;

@Repository(value = "historyDao")
public class HistoryDaoImpl extends AbstractDao<History, Integer> implements HistoryDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.HistoryDao#addHistory(com.thesis.geyou.entity.
	 * History)
	 */
	@Override
	public History addHistory(History h) {
		Integer id = create(h);
		return getByKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.HistoryDao#getHistory(java.lang.Integer)
	 */
	@Override
	public History getHistory(Integer id) {
		return getByKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.HistoryDao#getAllUserHistory(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<History> getAllUserHistory(Integer id, int page, int size) {
		Criteria criteria = createEntityCriteria("h");
		criteria.add(Restrictions.eq("h.userId", id));
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.HistoryDao#editHistory(com.thesis.geyou.entity.
	 * History)
	 */
	@Override
	public History editHistory(History h) {
		update(h);

		return getByKey(h.getId());
	}

}
