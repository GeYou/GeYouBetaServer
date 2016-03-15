package com.thesis.geyou.dao;

import java.util.List;

import com.thesis.geyou.entity.Message;
import com.thesis.geyou.entity.Party;

public interface MessageDao {

	Message createMessage(Message m);
	
	List<Message> getAllByParty(Party p);
	
	Message getMessage(Integer id);
}
