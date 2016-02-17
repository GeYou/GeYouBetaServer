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
@Table(name = "Party")
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

	@ManyToOne
	@JoinColumn(name = "createdBy", referencedColumnName = "id")
	private User createdBy;

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

	@Override
	public String toString() {
		return "[id : " + getId() + "] [name : " + getName() + "] [startDateTime : " + getStartDateTime()
				+ "] [endDateTime : " + getEndDateTime() + "] [destination : " + getDestination() + "] [destLong : "
				+ getDestLong() + "] [destLat : " + getDestLat() + "] [status : " + getStatus() + "] [createdDate : "
				+ getCreatedDate() + "] [createdBy : " + getCreatedBy() + "]";

	}

}