package com.thesis.geyou.service;

import java.util.List;

import com.thesis.geyou.entity.Message;

public interface MessageService {

	Message createMessage(Message m);
	
	List<Message> getMessageByParty(Integer id);
	
}
