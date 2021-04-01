package tn.cni.injez.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.sql.Date;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "autre_financement")
public class AutreFinancement {
	@Id
	private String code;
	private String libelle;
	private Date date_autre_financement;
	private Float montant;
	private Float montant_actualise;
	private Date date_actualisation;
	@ManyToOne(fetch=FetchType.LAZY)
	
	private Projet projet;

	public AutreFinancement(String code, String libelle,Date date_autre_financement, Float montant, Float montant_actualise,
			Date date_actualisation, Projet projet) {
		this.code = code;
		this.libelle = libelle;
		this.date_autre_financement = date_autre_financement;
		this.montant = montant;
		this.montant_actualise = montant_actualise;
		this.date_actualisation = date_actualisation;
		this.projet = projet;
	}

	public AutreFinancement() {

	}



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

	
	@Column(name = "date_autre_financement", nullable = false)

	public Date getDate_autre_financement() {
		return date_autre_financement;
	}

	public void setDate_autre_financement(Date date_autre_financement) {
		this.date_autre_financement = date_autre_financement;
	}

	@Column(name = "montant", nullable = false)

	public Float getMontant() {
		return montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}

	@Column(name = "montant_actualise")

	public Float getMontant_actualise() {
		return montant_actualise;
	}

	public void setMontant_actualise(Float montant_actualise) {
		this.montant_actualise = montant_actualise;
	}

	@Column(name = "date_actualisation")

	public Date getDate_actualisation() {
		return date_actualisation;
	}

	public void setDate_actualisation(Date date_actualisation) {
		this.date_actualisation = date_actualisation;
	}

	@Column(name = "projet_code", nullable = false)
	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

}
