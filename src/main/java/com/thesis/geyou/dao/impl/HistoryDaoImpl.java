/**
 * 
 */
package com.thesis.geyou.dao.impl;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.HistoryDao#getHistory(java.lang.Integer)
	 */
	@Override
	public History getHistory(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.HistoryDao#getAllUserHistory(java.lang.Integer)
	 */
	@Override
	public List<History> getAllUserHistory(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.HistoryDao#editHistory(com.thesis.geyou.entity.
	 * History)
	 */
	@Override
	public History editHistory(History h) {
		// TODO Auto-generated method stub
		return null;
	}

}
