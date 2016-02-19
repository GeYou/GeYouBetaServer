package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entity.Party;

public interface PartyService {

	Party getParty(Integer id);

	List<Party> getAll(int pNo, int pSize);

	Party createParty(Party p, Integer id);

	int deleteParty(Integer id);

	boolean checkName(String name);
	 
	Party updateParty(Party p);
}