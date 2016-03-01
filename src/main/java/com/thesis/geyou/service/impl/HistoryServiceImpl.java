package com.thesis.geyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.geyou.dao.HistoryDao;
import com.thesis.geyou.entity.History;
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
		return historyDao.getHistory(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<History> getAllUserHistory(Integer id) {
		return historyDao.getAllUserHistory(id);
	}

	@Override
	public History editHistory(History h) {
		return historyDao.editHistory(h);
	}
}