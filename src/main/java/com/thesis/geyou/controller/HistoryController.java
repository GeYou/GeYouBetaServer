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

import com.thesis.geyou.entity.History;
import com.thesis.geyou.service.HistoryService;

@RestController
@RequestMapping("/history")
public class HistoryController {

	@Autowired
	public HistoryService historyService;

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
	public List<History> getAllUserHistory(@PathVariable Integer id,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		return historyService.getAllUserHistory(id, page, size);
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public History editHistory(@RequestBody History h) {
		return historyService.editHistory(h);
	}
}
