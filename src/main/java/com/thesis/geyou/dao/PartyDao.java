package com.thesis.geyou.dao;

import java.util.List;

import com.thesis.geyou.entity.Party;

public interface PartyDao {
	
	Party getParty(Integer id);

	List<Party> getAll();

	Party createParty(Party p);

	int deleteParty(Integer id);

	Party getPartyByName(String name);

	Party updateParty(Party p);
}