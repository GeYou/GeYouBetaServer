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
	public HistoryDao historyDao;

	@Override
	public History addHistory(History h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public History getHistory(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<History> getAllUserHistory(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public History editHistory(History h) {
		// TODO Auto-generated method stub
		return null;
	}

}
