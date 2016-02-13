package com.thesis.geyou.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "History")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class History implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "startLong", columnDefinition = "DECIMAL(20, 10)")
	private Float startLong;
	
	@Column(name = "startLat", columnDefinition = "DECIMAL(20, 10)")
	private Float startLat;
	
	@Column(name = "endLong", columnDefinition = "DECIMAL(20, 10)")
	private Float endLong;
	
	@Column(name = "endLat", columnDefinition = "DECIMAL(20, 10)")
	private Float endLat;
	
	@OneToOne
	@JoinColumn(name = "partyId", referencedColumnName="id")
	private Party party;

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

	public Float getEndLong() {
		return endLong;
	}

	public void setEndLong(Float endLong) {
		this.endLong = endLong;
	}

	public Float getEndLat() {
		return endLat;
	}

	public void setEndLat(Float endLat) {
		this.endLat = endLat;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}
}
