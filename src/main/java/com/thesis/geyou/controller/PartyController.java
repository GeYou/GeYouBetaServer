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

import com.thesis.geyou.entities.Party;
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
	public List<Party> getAllParties(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		return partyService.getAll(page, size);
	}

	@RequestMapping(value = "/create", method = { RequestMethod.POST }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void createParty(@RequestBody Party p) {
		System.out.println("Party object: " + p);
		partyService.createParty(p);
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

	@RequestMapping(value = "/update", method = { RequestMethod.PUT })
	public void updateParty(@RequestBody Party p) {
		partyService.updateParty(p);
	}
}
