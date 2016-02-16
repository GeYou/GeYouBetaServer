package com.thesis.geyou.dao;

import java.util.List;

import com.thesis.geyou.entity.History;

public interface HistoryDao {
	History addHistory(History h);

	History getHistory(Integer id);

	List<History> getAllUserHistory(Integer id);

	History editHistory(History h);
}
