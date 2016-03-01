package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entity.History;

public interface HistoryService {
	
	History addHistory(History h);

	History getHistory(Integer id);

	List<History> getAllUserHistory(Integer id);

	History editHistory(History h);
}