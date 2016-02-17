package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entity.PartyMember;
import com.thesis.geyou.entity.User;

public interface PartyMemberService {
	
	public PartyMember addMember(PartyMember pm);
	
	public PartyMember getPartyMember(Integer id);

	public List<User> getPartyMembers(Integer id);
}
