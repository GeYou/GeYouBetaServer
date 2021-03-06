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

import com.thesis.geyou.entity.Party;
import com.thesis.geyou.service.PartyService;

@RestController
@RequestMapping("/party")
public class PartyController {

	@Autowired
	private PartyService partyService;

	@RequestMapping(value = "/get/{id}", method = { RequestMethod.GET }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Party getParty(@PathVariable Integer id) {
		return partyService.getParty(id);
	}

	@RequestMapping(value = "/get/all", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Party> getAllParties() {
		return partyService.getAll();
	}

	@RequestMapping(value = "/create/{id}", method = { RequestMethod.POST }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public Party createParty(@RequestBody Party p, @PathVariable Integer id) {
		System.out.println("Party object: " + p);
		return partyService.createParty(p, id);
	}

	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.DELETE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public int deleteParty(@PathVariable Integer id) {
		return partyService.deleteParty(id);
	}

	@RequestMapping(value = "/validateName", method = { RequestMethod.GET })
	public Boolean checkName(@RequestParam(value = "name") String name) {
		return partyService.checkName(name);
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Party updateParty(@RequestBody Party p) {
		return partyService.updateParty(p);
	}
}