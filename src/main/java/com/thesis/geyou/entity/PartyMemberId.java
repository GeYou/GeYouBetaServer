package com.thesis.geyou.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PartyMemberId implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Party party;

	@ManyToOne
	private User user;

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
