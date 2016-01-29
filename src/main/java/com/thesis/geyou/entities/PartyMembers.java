package com.thesis.geyou.entities;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PartyMembers")
@AssociationOverrides({ 
	@AssociationOverride(name = "pk.party", joinColumns = @JoinColumn(name = "party_id") ),
	@AssociationOverride(name = "pk.user", joinColumns = @JoinColumn(name = "user_id") ) })
public class PartyMembers {

	@EmbeddedId
	private PartyMembersId pk = new PartyMembersId();

	public PartyMembersId getPk() {
		return pk;
	}

	public void setPk(PartyMembersId pk) {
		this.pk = pk;
	}

	@Transient
	public User getUser() {
		return getPk().getUser();
	}

	public void setUser(User user) {
		getPk().setUser(user);
	}

	@Transient
	public Party getParty() {
		return getPk().getParty();
	}

	public void setParty(Party party) {
		getPk().setParty(party);
	}
}
