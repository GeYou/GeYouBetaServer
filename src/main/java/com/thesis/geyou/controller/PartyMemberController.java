package com.thesis.geyou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thesis.geyou.entity.PartyMember;
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
}
