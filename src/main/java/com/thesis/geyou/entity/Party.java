package com.thesis.geyou.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Party")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
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

	@Column(name = "destLong", columnDefinition = "DECIMAL(20, 10)")
	private Float destLong;

	@Column(name = "destLat", columnDefinition = "DECIMAL(20, 10)")
	private Float destLat;

	@Column(name = "status")
	private String status;

	@Column(name = "createdDate", updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@OneToOne
	@JoinColumn(name = "createdBy", referencedColumnName = "id")
	private User createdBy;

	@SuppressWarnings("deprecation")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.party", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
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

	public Float getDestLong() {
		return destLong;
	}

	public void setDestLong(Float destLong) {
		this.destLong = destLong;
	}

	public Float getDestLat() {
		return destLat;
	}

	public void setDestLat(Float destLat) {
		this.destLat = destLat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Set<PartyMember> getPartyMembers() {
		return partyMembers;
	}

	public void setPartyMembers(Set<PartyMember> partyMembers) {
		this.partyMembers = partyMembers;
	}

	@Override
	public String toString() {
		return "[id : " + getId() + "] [name : " + getName() + "] [startDateTime : " + getStartDateTime()
				+ "] [endDateTime : " + getEndDateTime() + "] [destination : " + getDestination() + "] [destLong : "
				+ getDestLong() + "] [destLat : " + getDestLat() + "] [status : " + getStatus() + "] [createdDate : "
				+ getCreatedDate() + "] [createdBy : " + getCreatedBy() + "]";
	}

}