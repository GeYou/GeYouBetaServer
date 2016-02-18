package com.thesis.geyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.geyou.dao.PartyDao;
import com.thesis.geyou.entity.Party;
import com.thesis.geyou.entity.PartyMember;
import com.thesis.geyou.entity.User;
import com.thesis.geyou.service.PartyMemberService;
import com.thesis.geyou.service.PartyService;

@Transactional
@Service(value = "partyService")
public class PartyServiceImpl implements PartyService {

	@Autowired
	public PartyDao partyDao;
	
	@Autowired
	public PartyMemberService partyMemberService;

	@Override
	public Party getParty(Integer id) {
		return partyDao.getParty(id);
	}

	@Override
	public List<Party> getAll(int pNo, int pSize) {
		return partyDao.getAll(pNo, pSize);
	}

	@Override
	public Party createParty(Party p, Integer id) {
		User u = new User();
		u.setId(id);
		p.setCreatedBy(u);
		
		Party nParty = partyDao.createParty(p);
		
		PartyMember pm = new PartyMember();
		pm.setUser(u);
		pm.setParty(nParty);
		partyMemberService.addMember(pm);
		
		return nParty;
	}

	@Override
	public int deleteParty(Integer id) {
		return partyDao.deleteParty(id);
	}

	@Override
	public boolean checkName(String name) {
		if (partyDao.getPartyByName(name) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Party updateParty(Party p) {
		return partyDao.updateParty(p);
	}
}