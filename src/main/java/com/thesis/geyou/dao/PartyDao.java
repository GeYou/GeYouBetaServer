package com.thesis.geyou.dao;

import java.util.List;

import com.thesis.geyou.entities.Party;

public interface PartyDao {
	Party getParty(Integer id);

	List<Party> getAll(int pNo, int pSize);

	Party createParty(Party p);

	void updateParty(Party p);

	int deleteParty(Integer id);
	
	Party getPartyByName(String name);
}
