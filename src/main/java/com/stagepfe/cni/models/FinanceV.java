package com.stagepfe.cni.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(	name = "finances")
public class FinanceV {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "anneeV")
	private String anneeV;
	
	@Column(name = "periodeV")
	private String periodeV;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicule_id", nullable = false)
    @JsonIgnore
    private Vehicule vehicule;

	public FinanceV() {
		
	}

	public FinanceV(String anneeV, String periodeV) {
		super();
		this.anneeV = anneeV;
		this.periodeV = periodeV;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAnneeV() {
		return anneeV;
	}

	public void setAnneeV(String anneeV) {
		this.anneeV = anneeV;
	}

	public String getPeriodeV() {
		return periodeV;
	}

	public void setPeriodeV(String periodeV) {
		this.periodeV = periodeV;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
}
