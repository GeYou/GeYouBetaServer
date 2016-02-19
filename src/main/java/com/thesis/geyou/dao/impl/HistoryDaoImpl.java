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

	@Override
	public History addHistory(History h) {
		Integer id = create(h);
		return getByKey(id);
	}

	@Override
	public History getHistory(Integer id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<History> getAllUserHistory(Integer id, int page, int size) {
		Criteria criteria = createEntityCriteria("h");
		criteria.add(Restrictions.eq("h.userId", id));
		return criteria.list();
	}

	@Override
	public History editHistory(History h) {
		update(h);

		return getByKey(h.getId());
	}
}