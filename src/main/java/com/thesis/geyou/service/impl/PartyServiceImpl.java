package com.thesis.geyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.geyou.dao.PartyDao;
import com.thesis.geyou.dao.UserDao;
import com.thesis.geyou.entity.Party;
import com.thesis.geyou.service.PartyService;

@Transactional
@Service(value = "partyService")
public class PartyServiceImpl implements PartyService {

	@Autowired
	public PartyDao partyDao;
	
	@Autowired
	public UserDao userDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.service.PartyService#createParty(com.thesis.geyou.
	 * entities.Party)
	 */
	@Override
	public void createParty(Party p) {
		partyDao.createParty(p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.service.PartyService#getAll(int, int)
	 */
	@Override
	public List<Party> getAll(int pNo, int pSize) {
		return partyDao.getAll(pNo, pSize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.service.PartyService#getParty(java.lang.Integer)
	 */
	@Override
	public Party getParty(Integer id) {
		return partyDao.getParty(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.service.PartyService#updateParty(com.thesis.geyou.
	 * entities.Party)
	 */
	@Override
	public void updateParty(Party p) {
		partyDao.updateParty(p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.service.PartyService#deleteParty(java.lang.Integer)
	 */
	@Override
	public int deleteParty(Integer id) {
		return partyDao.deleteParty(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thesis.geyou.service.PartyService#checkName(java.lang.String)
	 */
	@Override
	public boolean checkName(String name) {
		if (partyDao.getPartyByName(name) != null) {
			return true;
		} else {
			return false;
		}
	}

}
