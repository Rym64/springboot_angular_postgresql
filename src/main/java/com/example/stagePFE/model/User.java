package com.example.stagePFE.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "adress")
	private String adress;

	@Column(name = "cin")
	private String cin;
	
	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "pwd")
	private String pwd;

	public User(long id, String first_name, String last_name, String adress, String cin, String phone, String email,
			String pwd) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.adress = adress;
		this.cin = cin;
		this.phone = phone;
		this.email = email;
		this.pwd = pwd;
	}

	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", adress=" + adress
				+ ", cin=" + cin + ", phone=" + phone + ", email=" + email + ", pwd=" + pwd + "]";
	}
	
	
}
