package com.thesis.geyou.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "PartyMember")
@AssociationOverrides({ 
	@AssociationOverride(name = "pk.party", joinColumns = @JoinColumn(name = "partyId") ),
	@AssociationOverride(name = "pk.user", joinColumns = @JoinColumn(name = "userId") ) })
public class PartyMember implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PartyMemberId pk = new PartyMemberId();

	public PartyMemberId getPk() {
		return pk;
	}

	public void setPk(PartyMemberId pk) {
		this.pk = pk;
	}

	@Transient
	@JsonBackReference("User")
	public User getUser() {
		return getPk().getUser();
	}

	public void setUser(User user) {
		getPk().setUser(user);
	}

	@Transient
	@JsonBackReference("Party")
	public Party getParty() {
		return getPk().getParty();
	}

	public void setParty(Party party) {
		getPk().setParty(party);
	}
}
