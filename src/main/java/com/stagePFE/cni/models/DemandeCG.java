package com.stagePFE.cni.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "demandecgs")

public class DemandeCG {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	
	@Column(name = "cin")
	private String cin;

	@Column(name = "placebirth")
	private String placebirth;
	
	@Column(name = "nationality")
	private String nationality;

	@Column(name = "city")
	private String city;
	
	@Column(name = "postalcode")
	private String postalcode;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

	public DemandeCG(String cin, String placebirth, String nationality, String city, String postalcode) {
		super();
		this.cin = cin;
		this.placebirth = placebirth;
		this.nationality = nationality;
		this.city = city;
		this.postalcode = postalcode;
	}

	public DemandeCG() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPlacebirth() {
		return placebirth;
	}

	public void setPlacebirth(String placebirth) {
		this.placebirth = placebirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "DemandeCG [id=" + id + ", cin=" + cin + ", placebirth=" + placebirth + ", nationality=" + nationality
				+ ", city=" + city + ", postalcode=" + postalcode + "]";
	}
	
}


