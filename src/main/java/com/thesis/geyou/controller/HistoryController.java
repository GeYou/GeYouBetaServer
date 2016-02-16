package com.thesis.geyou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

}
