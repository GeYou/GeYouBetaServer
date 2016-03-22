package com.thesis.geyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.geyou.dao.HistoryDao;
import com.thesis.geyou.entity.History;
import com.thesis.geyou.entity.Party;
import com.thesis.geyou.entity.User;
import com.thesis.geyou.service.HistoryService;

@Transactional
@Service(value = "historyService")
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	private HistoryDao historyDao;

	@Override
	public History addHistory(History h) {
		return historyDao.addHistory(h);
	}

	@Override
	@Transactional(readOnly = true)
	public History getHistory(Integer id) {
		History h = historyDao.getHistory(id);
		
		if (h == null) {
			h = new History();
		}
		
		return h;
	}

	@Override
	@Transactional(readOnly = true)
	public List<History> getAllUserHistory(Integer id) {
		User u = new User();
		u.setId(id);
		
		return historyDao.getAllUserHistory(u);
	}

	@Override
	public History editHistory(History h) {
		return historyDao.editHistory(h);
	}
	
	@Override
	public History getHistoryByUserAndParty(Integer pId, Integer uId) {
		Party p = new Party();
		User u = new User();
		
		p.setId(pId);
		u.setId(uId);
		
		History h = historyDao.getHistoryByUserAndParty(p, u);
		
		if (h == null) {
			h = new History();
		}
		
		return h;
	}

	@Override
	public List<History> getHistoryPoints(Integer pId, Integer uId) {
		User u = new User();
		Party p = new Party();
		
		u.setId(uId);
		p.setId(pId);
		
		return historyDao.getHistoryPoints(u, p);
	}
}