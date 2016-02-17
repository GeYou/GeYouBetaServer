package com.thesis.geyou.dao;

import com.thesis.geyou.entity.PartyMember;

public interface PartyMemberDao {
	
	PartyMember addMember(PartyMember pm);
	
	PartyMember getPartyMember(Integer id);

}
