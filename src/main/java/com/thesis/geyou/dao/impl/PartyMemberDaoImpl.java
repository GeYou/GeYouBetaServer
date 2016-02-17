package com.thesis.geyou.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.thesis.geyou.dao.AbstractDao;
import com.thesis.geyou.dao.PartyMemberDao;
import com.thesis.geyou.entity.Party;
import com.thesis.geyou.entity.PartyMember;

@Repository(value = "partyMemberDao")
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

	@SuppressWarnings("unchecked")
	@Override
	public List<PartyMember> getPartyMembersByParty(Party p) {
		Criteria criteria = createEntityCriteria("pm");
		criteria.add(Restrictions.eq("pm.party", p));
		return criteria.list();
	}

}
