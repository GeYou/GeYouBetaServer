package com.thesis.geyou.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PartyMember")
public class PartyMember implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "partyId", referencedColumnName = "id")
	private Party party;
	
	@Column(name = "lastLong", columnDefinition = "DECIMAL(20, 15)")
	private Double lastLong;

	@Column(name = "lastLat", columnDefinition = "DECIMAL(20, 15)")
	private Double lastLat;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "joinDate", updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private Date joinDate;
	
	@Column(name = "status")
	private String status;
	
	public Date getJoinDate() {
		return joinDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Party getParty() {
		return party;
	}

	public Double getLastLong() {
		return lastLong;
	}

	public void setLastLong(Double lastLong) {
		this.lastLong = lastLong;
	}

	public Double getLastLat() {
		return lastLat;
	}

	public void setLastLat(Double lastLat) {
		this.lastLat = lastLat;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}