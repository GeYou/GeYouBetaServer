package com.thesis.geyou.dao;

import java.util.List;

import com.thesis.geyou.entity.History;
import com.thesis.geyou.entity.User;

public interface HistoryDao {
	
	History addHistory(History h);

	History getHistory(Integer id);

	List<History> getAllUserHistory(User u);

	History editHistory(History h);
}