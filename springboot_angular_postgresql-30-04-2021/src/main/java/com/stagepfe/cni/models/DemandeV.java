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
@Table(	name = "lesdemande")
public class DemandeV {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "etatdemande")
	private String etatdemande;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicule_id", nullable = false)
    @JsonIgnore
    private Vehicule vehicule;

	
	
	public DemandeV(long id, String etatdemande) {
	
		this.id = id;
		this.etatdemande = etatdemande;
	}


	public DemandeV() {
	
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getEtatdemande() {
		return etatdemande;
	}


	public void setEtatdemande(String etatdemande) {
		this.etatdemande = etatdemande;
	}
	

	public Vehicule getVehicule() {
		return vehicule;
	}

	
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
	
}
