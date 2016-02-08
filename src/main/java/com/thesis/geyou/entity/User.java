package com.thesis.geyou.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "Users")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "fName", length = 25)
	private String fName;

	@Column(name = "lName", length = 30)
	private String lName;

	@Column(name = "email", length = 45, unique = true)
	private String email;

	@Column(name = "password", length = 20)
	private String password;
	
	@Column(name = "createdDate")
	private Date createdDate;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.user", cascade=CascadeType.ALL)
	private Set<PartyMember> partyMembers = new HashSet<PartyMember>(0);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Set<PartyMember> getPartyMembers() {
		return partyMembers;
	}

	public void setPartyMembers(Set<PartyMember> partyMembers) {
		this.partyMembers = partyMembers;
	}

	@Override
	public String toString() {
		return "[id : " + getId() + "] [fname : " + getfName() + "] [lname : " + getlName() + "] [email : " + getEmail() + "] [password : " + getPassword() + "] [createdDate : " + getCreatedDate() + "]";
	}

}
