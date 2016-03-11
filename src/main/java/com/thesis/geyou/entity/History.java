package com.thesis.geyou.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "History")
public class History implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "startLong", columnDefinition = "DECIMAL(20, 10)")
	private Float startLong;

	@Column(name = "startLat", columnDefinition = "DECIMAL(20, 10)")
	private Float startLat;

	@ManyToOne
	@JoinColumn(name = "partyId", referencedColumnName = "id")
	private Party party;

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getStartLong() {
		return startLong;
	}

	public void setStartLong(Float startLong) {
		this.startLong = startLong;
	}

	public Float getStartLat() {
		return startLat;
	}

	public void setStartLat(Float startLat) {
		this.startLat = startLat;
	}

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