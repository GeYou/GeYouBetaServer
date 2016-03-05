package com.thesis.geyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thesis.geyou.entity.History;
import com.thesis.geyou.entity.Party;
import com.thesis.geyou.entity.User;
import com.thesis.geyou.service.HistoryService;

@RestController
@RequestMapping("/history")
public class HistoryController {

	@Autowired
	private HistoryService historyService;

	@RequestMapping(value = "/add", method = { RequestMethod.POST }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public History addHistory(@RequestBody History h) {
		return historyService.addHistory(h);
	}

	@RequestMapping(value = "/get/{id}", method = { RequestMethod.GET }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public History getHistory(@PathVariable Integer id) {
		return historyService.getHistory(id);
	}

	@RequestMapping(value = "/getAll/{id}", method = { RequestMethod.GET }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<History> getAllUserHistory(@PathVariable Integer id) {
		return historyService.getAllUserHistory(id);
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public History editHistory(@RequestBody History h) {
		return historyService.editHistory(h);
	}
	
	@RequestMapping(value = "/getExistingHistory", method = { RequestMethod.GET }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public History getHistoryByUserAndParty(@RequestBody Party p, @RequestBody User u) {
		return historyService.getHistoryByUserAndParty(p, u);
	}
}