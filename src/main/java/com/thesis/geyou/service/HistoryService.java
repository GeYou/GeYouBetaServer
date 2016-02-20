package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entity.History;

public interface HistoryService {
	
	History addHistory(History h);

	History getHistory(Integer id);

	List<History> getAllUserHistory(Integer id, int page, int size);

	History editHistory(History h);
}