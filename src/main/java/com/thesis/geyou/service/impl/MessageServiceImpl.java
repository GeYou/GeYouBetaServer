package com.thesis.geyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thesis.geyou.dao.MessageDao;
import com.thesis.geyou.entity.Message;
import com.thesis.geyou.entity.Party;
import com.thesis.geyou.service.MessageService;

public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;
	
	@Override
	public Message createMessage(Message m) {
		return messageDao.createMessage(m);
	}

	@Override
	public List<Message> getMessageByParty(Integer id) {
		Party p = new Party();
		p.setId(id);
		
		List<Message> msg = messageDao.getAllByParty(p);
		
		return msg;
	}

}
