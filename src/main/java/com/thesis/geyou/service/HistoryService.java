package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entity.History;
import com.thesis.geyou.entity.Party;
import com.thesis.geyou.entity.User;

public interface HistoryService {
	
	History addHistory(History h);

	History getHistory(Integer id);

	List<History> getAllUserHistory(Integer id);

	History editHistory(History h);
	
	History getHistoryByUserAndParty(Party p, User u);
}