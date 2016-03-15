package com.thesis.geyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thesis.geyou.entity.Message;
import com.thesis.geyou.service.MessageService;

@RestController
@RequestMapping("/msg")
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/create", method = { RequestMethod.POST }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Message createUser(@RequestBody Message m) {
		System.out.println("Message object: " + m);

		return messageService.createMessage(m);
	}
	
	@RequestMapping(value = "/getByParty/{id}", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Message> getPartyMembersByParty(@PathVariable Integer id) {
		return messageService.getMessageByParty(id);
	}
	
}
