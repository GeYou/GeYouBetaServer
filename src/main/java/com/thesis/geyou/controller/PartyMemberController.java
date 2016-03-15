package com.thesis.geyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thesis.geyou.entity.PartyMember;
import com.thesis.geyou.entity.User;
import com.thesis.geyou.service.PartyMemberService;

@RestController
@RequestMapping("/partyMember")
public class PartyMemberController {

	@Autowired
	private PartyMemberService partyMemberService;

	@RequestMapping(value = "/add", method = { RequestMethod.POST }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public PartyMember addMember(@RequestBody PartyMember pm) {
		return partyMemberService.addMember(pm);
	}
	
	@RequestMapping(value = "/get/{id}", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public PartyMember getPartyMember(@PathVariable Integer id) {
		return partyMemberService.getPartyMember(id);
	}
	
	@RequestMapping(value = "/getByParty/{id}", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<User> getPartyMembersByParty(@PathVariable Integer id) {
		return partyMemberService.getPartyMembers(id);
	}
	
	@RequestMapping(value = "/getActiveParty/{id}", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public PartyMember getActiveParty(@PathVariable Integer id) {
		return partyMemberService.getActiveParty(id);
	}
	
	@RequestMapping(value = "/checkPartyMembership", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Boolean checkPartyMembership(@RequestParam(value = "partyId") Integer partyId,
										@RequestParam(value = "userId") Integer userId) {
		return partyMemberService.checkPartyMemberExist(partyId, userId);
	}
	
	@RequestMapping(value = "/getByUserAndParty", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public PartyMember getPartyMemberByUserAndParty(@RequestParam(value = "partyId") Integer pId, 
													@RequestParam(value = "userId") Integer uId){
		return partyMemberService.getPartyMemberByUSerAndParty(pId, uId);
	}
	
	@RequestMapping(value = "/edit", method = { RequestMethod.PUT }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public PartyMember editMember(@RequestBody PartyMember pm) {
		return partyMemberService.editMember(pm);
	}
	
	@RequestMapping(value = "/getMembersByParty/{id}", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<PartyMember> getMembersByParty(@PathVariable Integer id){
		return partyMemberService.getPartyMembersByParty(id);
	}
}