package com.thesis.geyou.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.thesis.geyou.dao.AbstractDao;
import com.thesis.geyou.dao.MessageDao;
import com.thesis.geyou.entity.Message;
import com.thesis.geyou.entity.Party;

@Repository(value = "messageDao")
public class MessageDaoImpl extends AbstractDao<Message, Integer> implements MessageDao {

	@Override
	public Message createMessage(Message m) {
		Integer id = create(m);
		return getMessage(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getAllByParty(Party p) {
		Criteria criteria = createEntityCriteria("m");
		criteria.add(Restrictions.eq("m.party", p));
		
		return criteria.list();
	}

	@Override
	public Message getMessage(Integer id) {
		return getByKey(id);
	}
}
