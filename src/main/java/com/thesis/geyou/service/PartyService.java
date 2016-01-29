package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entities.Party;

public interface PartyService {

	public void createParty(Party p);

	public List<Party> getAll(int pNo, int pSize);

	public Party getParty(Integer id);

	public void updateParty(Party p);

	public int deleteParty(Integer id);

	public boolean checkName(String name);
}
