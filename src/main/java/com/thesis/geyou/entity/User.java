package com.thesis.geyou.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
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
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="PartyMembers", 
                joinColumns={@JoinColumn(name="userId")}, 
                inverseJoinColumns={@JoinColumn(name="partyId")})
    private Set<Party> parties = new HashSet<Party>();

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

	public Set<Party> getMeetings() {
		return parties;
	}

	public void setParties(Set<Party> parties) {
		this.parties = parties;
	}

	@Override
	public String toString() {
		return "[id : " + getId() + "] [fname : " + getfName() + "]";
	}

}
