package com.thesis.geyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.geyou.dao.MessageDao;
import com.thesis.geyou.entity.Message;
import com.thesis.geyou.entity.Party;
import com.thesis.geyou.service.MessageService;

@Transactional
@Service(value = "messageService")
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
