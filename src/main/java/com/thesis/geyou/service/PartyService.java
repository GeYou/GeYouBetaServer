package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entity.Party;

public interface PartyService {

	public Party getParty(Integer id);

	public List<Party> getAll(int pNo, int pSize);

	public Party createParty(Party p, Integer id);

	public int deleteParty(Integer id);

	public boolean checkName(String name);

	public Party updateParty(Party p);

	public Party addMember(Party p, Integer id);
}