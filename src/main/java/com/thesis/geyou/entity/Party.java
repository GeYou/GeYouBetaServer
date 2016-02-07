package com.thesis.geyou.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Party")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Party implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", length = 45, unique = true)
	private String name;

	@Column(name = "startDateTime")
	private String startDateTime;

	@Column(name = "endDateTime")
	private String endDateTime;

	@Column(name = "destination")
	private String destination;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.party")
	private Set<PartyMember> partyMembers = new HashSet<PartyMember>(0);
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Set<PartyMember> getPartyMembers() {
		return partyMembers;
	}

	public void setPartyMembers(Set<PartyMember> partyMembers) {
		this.partyMembers = partyMembers;
	}

	@Override
	public String toString() {
		return "[id : " + getId() + "] [name : " + getName() + "]";
	}

}
