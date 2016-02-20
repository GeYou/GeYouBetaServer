package com.thesis.geyou.dao;

import java.util.List;

import com.thesis.geyou.entity.Party;
import com.thesis.geyou.entity.PartyMember;
import com.thesis.geyou.entity.User;

public interface PartyMemberDao {
	
	PartyMember addMember(PartyMember pm);
	
	PartyMember getPartyMember(Integer id);

	List<PartyMember> getPartyMembersByParty(Party p);
	
	PartyMember getActiveParty(User u);
	
	PartyMember getByUserAndParty(User u, Party p);
}