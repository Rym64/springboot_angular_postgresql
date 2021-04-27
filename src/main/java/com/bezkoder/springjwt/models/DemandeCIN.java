package com.bezkoder.springjwt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "demandecins")

public class DemandeCIN {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

	

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "datebirth")
	private String datebirth;
	

	@Column(name = "placebirth")
	private String placebirth;
	
	@Column(name = "nationality")
	private String nationality;

	@Column(name = "city")
	private String city;
	
	@Column(name = "postalcode")
	private String postalcode;

	@Column(name = "address")
	private String address;


	@Column(name = "mothername")
	private String mothername;

	@Column(name = "fathername")
	private String fathername;
	

	@Column(name = "job")
	private String job;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDatebirth() {
		return datebirth;
	}

	public void setDatebirth(String datebirth) {
		this.datebirth = datebirth;
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
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
	public DemandeCIN() {
		
	}

	public DemandeCIN(String firstname, String lastname, String email, String phone, String datebirth,
			String placebirth, String nationality, String city, String postalcode, String address, String mothername,
			String fathername, String job) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.datebirth = datebirth;
		this.placebirth = placebirth;
		this.nationality = nationality;
		this.city = city;
		this.postalcode = postalcode;
		this.address = address;
		this.mothername = mothername;
		this.fathername = fathername;
		this.job = job;
	}

	@Override
	public String toString() {
		return "DemandeCIN [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phone=" + phone + ", datebirth=" + datebirth + ", placebirth=" + placebirth + ", nationality="
				+ nationality + ", city=" + city + ", postalcode=" + postalcode + ", address=" + address
				+ ", mothername=" + mothername + ", fathername=" + fathername + ", job=" + job + "]";
	}

	

	
	
	
}


