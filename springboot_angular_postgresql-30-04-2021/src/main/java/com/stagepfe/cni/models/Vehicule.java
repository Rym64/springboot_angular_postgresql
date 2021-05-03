package com.stagepfe.cni.models;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(	name = "vehicules", uniqueConstraints = { 
		@UniqueConstraint(columnNames = "immatD")})
public class Vehicule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "dmc")
	private String dmc;
	
	@Column(name = "immatD")
	private String immatD;
	
	@Column(name = "immatG")
	private String immatG;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "vehicules_types", joinColumns = @JoinColumn(name = "vehicule_id"), 
				inverseJoinColumns = @JoinColumn(name = "type_id"))
	private Set<TypeEm> type = new HashSet<>();

	@OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<FinanceV> financevs;
	
	public Vehicule() {
		
	}

	public Vehicule(String dmc, String immatD, String immatG) {
		super();
		this.dmc = dmc;
		this.immatD = immatD;
		this.immatG = immatG;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDmc() {
		return dmc;
	}

	public void setDmc(String dmc) {
		this.dmc = dmc;
	}

	public String getImmatD() {
		return immatD;
	}

	public void setImmatD(String immatD) {
		this.immatD = immatD;
	}
	
	public String getImmatG() {
		return immatG;
	}

	public void setImmatG(String immatG) {
		this.immatG = immatG;
	}

	public Set<TypeEm> getType() {
		return type;
	}

	public void setType(Set<TypeEm> type) {
		this.type = type;
	}

	public Set<FinanceV> getFinancevs() {
		return financevs;
	}

	public void setFinancevs(Set<FinanceV> financevs) {
		this.financevs = financevs;
	}

}
