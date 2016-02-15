package com.thesis.geyou.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "PartyMember")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
@AssociationOverrides({ 
	@AssociationOverride(name = "pk.party", joinColumns = @JoinColumn(name = "partyId") ),
	@AssociationOverride(name = "pk.user", joinColumns = @JoinColumn(name = "userId") ) })
public class PartyMember implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PartyMemberId pk = new PartyMemberId();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "joinDate", updatable=false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
	private Date joinDate;

	public PartyMemberId getPk() {
		return pk;
	}

	public void setPk(PartyMemberId pk) {
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

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}