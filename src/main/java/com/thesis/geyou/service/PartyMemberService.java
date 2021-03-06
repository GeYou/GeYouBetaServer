package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entity.PartyMember;
import com.thesis.geyou.entity.User;

public interface PartyMemberService {
	
	PartyMember addMember(PartyMember pm);
	
	PartyMember getPartyMember(Integer id);

	List<User> getPartyMembers(Integer id);
	
	PartyMember getActiveParty(Integer id);
	
	Boolean checkPartyMemberExist(Integer pId, Integer uId);
	
	PartyMember getPartyMemberByUSerAndParty(Integer pId, Integer uId);
	
	PartyMember editMember(PartyMember pm);
	
	List<PartyMember> getPartyMembersByParty(Integer id);
}