package com.thesis.geyou.dao.impl;

import com.thesis.geyou.dao.AbstractDao;
import com.thesis.geyou.dao.PartyMemberDao;
import com.thesis.geyou.entity.PartyMember;

public class PartyMemberDaoImpl extends AbstractDao<PartyMember, Integer> implements PartyMemberDao {

	@Override
	public PartyMember addMember(PartyMember pm) {
		Integer id = create(pm);
		
		return getByKey(id);
	}

	@Override
	public PartyMember getPartyMember(Integer id) {
		return getByKey(id);
	}

}
