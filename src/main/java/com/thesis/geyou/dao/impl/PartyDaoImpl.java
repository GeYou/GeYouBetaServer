package com.thesis.geyou.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.thesis.geyou.dao.AbstractDao;
import com.thesis.geyou.dao.PartyDao;
import com.thesis.geyou.entity.Party;

@Repository(value = "partyDao")
public class PartyDaoImpl extends AbstractDao<Party, Integer> implements PartyDao {

	@Override
	public Party getParty(Integer id) {
		return getByKey(id);
	}

	@Override
	public List<Party> getAll() {
		return getAllEntities();
	}

	@Override
	public Party createParty(Party p) {
		Integer id = create(p);
		return getParty(id);
	}

	@Override
	public int deleteParty(Integer id) {
		return delete(id);
	}

	@Override
	public Party getPartyByName(String name) {
		Criteria criteria = createEntityCriteria("p");
		criteria.add(Restrictions.eq("p.name", name));
		return (Party) criteria.uniqueResult();
	}

	@Override
	public Party updateParty(Party p) {
		update(p);

		return getParty(p.getId());
	}
}