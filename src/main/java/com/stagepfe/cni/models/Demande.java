package com.stagepfe.cni.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(	name = "demande")
public class Demande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "etat")
	private TypeDemande type;
	
	@Column(name = "etat")
	private String etat;

	public Demande() {
		
	}

	public Demande(Long id, TypeDemande type, String etat) {
		super();
		this.id = id;
		this.type = type;
		this.etat = etat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeDemande getType() {
		return type;
	}

	public void setType(TypeDemande type) {
		this.type = type;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
}
