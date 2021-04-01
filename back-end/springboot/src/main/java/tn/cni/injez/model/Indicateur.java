package tn.cni.injez.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "indicateur")
public class Indicateur {
	@Id
    private String code;
	private String libelle;
	private String description;
	@ManyToOne(fetch=FetchType.LAZY)
    private Objectif objectif;
	
	public Indicateur(String code,String libelle, String description,Objectif objectif) {
		
	
		this.code = code;
		this.libelle=libelle;
		this.description = description;
		this.objectif = objectif;
	}
	
	public Indicateur ()
	{}



	@Column(name = "code", nullable = false)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	
	@Column(name = "libelle", nullable = false)
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

	@Column(name = "objectif_code", nullable = false)

	public Objectif getObjectif() {
		return objectif;
	}

	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
	}

}
