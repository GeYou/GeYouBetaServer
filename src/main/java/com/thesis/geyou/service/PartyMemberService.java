package com.thesis.geyou.service;

import com.thesis.geyou.entity.PartyMember;

public interface PartyMemberService {
	
	public PartyMember addMember(PartyMember pm);
	
	public PartyMember getPartyMember(Integer id);

}
