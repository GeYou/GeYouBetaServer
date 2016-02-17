package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entity.History;

public interface HistoryService {
	public History addHistory(History h);

	public History getHistory(Integer id);

	public List<History> getAllUserHistory(Integer id, int page, int size);

	public History editHistory(History h);
}
