package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entity.Party;

public interface PartyService {

	public Party createParty(Party p, Integer id);

	public List<Party> getAll(int pNo, int pSize);

	public Party getParty(Integer id);

	public void updateParty(Party p);

	public int deleteParty(Integer id);

	public boolean checkName(String name);
}
