package com.thesis.geyou.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.geyou.dao.PartyMemberDao;
import com.thesis.geyou.entity.Party;
import com.thesis.geyou.entity.PartyMember;
import com.thesis.geyou.entity.User;
import com.thesis.geyou.service.PartyMemberService;

@Transactional
@Service(value = "partyMemberService")
public class PartyMemberServiceImpl implements PartyMemberService {

	@Autowired
	private PartyMemberDao partyMemberDao;
	
	@Override
	public PartyMember addMember(PartyMember pm) {
		pm.setStatus("A");
		return partyMemberDao.addMember(pm);
	}

	@Override
	@Transactional(readOnly = true)
	public PartyMember getPartyMember(Integer id) {
		return partyMemberDao.getPartyMember(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getPartyMembers(Integer id) {
		Party p = new Party();
		p.setId(id);
		
		List<PartyMember> pm = partyMemberDao.getPartyMembersByParty(p);
		
		List<User> u = new ArrayList<User>();
		for (PartyMember partyMember : pm) {
			u.add(partyMember.getUser());
		}
		
		return u;
	}

	@Override
	public PartyMember getActiveParty(Integer id) {
		User u = new User();
		u.setId(id);
		
		PartyMember pm = partyMemberDao.getActiveParty(u); 
		
		if(pm == null) {
			pm = new PartyMember();
		}
		
		return pm;
	}

	@Override
	public Boolean checkPartyMemberExist(Integer pId, Integer uId) {
		Party p = new Party();
		p.setId(pId);
		User u = new User();
		u.setId(uId);
		
		if (partyMemberDao.getByUserAndParty(u, p) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public PartyMember getPartyMemberByUSerAndParty(Integer pId, Integer uId) {
		PartyMember pm = new PartyMember();
		
		Party p = new Party();
		p.setId(pId);
		User u = new User();
		u.setId(uId);
		
		pm = partyMemberDao.getByUserAndParty(u, p);
		
		if(pm == null) {
			pm = new PartyMember();
		}
		
		return pm;
	}
	
	@Override
	public PartyMember editMember(PartyMember pm) {
		return partyMemberDao.editMember(pm);
	}
}