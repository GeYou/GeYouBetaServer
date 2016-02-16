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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.PartyDao#getParty(java.lang.Integer)
	 */
	@Override
	public Party getParty(Integer id) {
		return getByKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.PartyDao#getAll(int, int)
	 */
	@Override
	public List<Party> getAll(int pNo, int pSize) {
		return getAllEntities(pNo, pSize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.PartyDao#createParty(com.thesis.geyou.entities.
	 * Party)
	 */
	@Override
	public Party createParty(Party p) {
		Integer id = create(p);
		return getParty(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.PartyDao#updateParty(com.thesis.geyou.entities.
	 * Party)
	 */
	@Override
	public Party updateParty(Party p) {
		update(p);

		return getParty(p.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.PartyDao#deleteParty(java.lang.Integer)
	 */
	@Override
	public int deleteParty(Integer id) {
		return delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.dao.PartyDao#getPartyByName(java.lang.String)
	 */
	@Override
	public Party getPartyByName(String name) {
		Criteria criteria = createEntityCriteria("p");
		criteria.add(Restrictions.eq("p.name", name));
		return (Party) criteria.uniqueResult();
	}

}
