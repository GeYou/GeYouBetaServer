package com.thesis.geyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.thesis.geyou.dao.PartyMemberDao;
import com.thesis.geyou.entity.PartyMember;
import com.thesis.geyou.service.PartyMemberService;

public class PartyMemberServiceImpl implements PartyMemberService {

	@Autowired
	private PartyMemberDao partyMemberDao;
	
	@Override
	public PartyMember addMember(PartyMember pm) {
		return partyMemberDao.addMember(pm);
	}

	@Override
	public PartyMember getPartyMember(Integer id) {
		return partyMemberDao.getPartyMember(id);
	}

}
