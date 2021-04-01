package tn.cni.injez.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.sql.Date;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "financement_etranger")
public class FinancementEtranger {
	@Id
	private String code;
	private String libelle;
	private Devise devise;
	private Pays pays_financement;
	private String pays_geocoordinates;
	private Float montant_dt;
	private Float montant_actualise;
	private Date date_actualisation;
	private Financeur financeur;
	private Date date_signature;
	private Date date_debut;
	private Date date_cloture;
	private Date date_delai;
	@ManyToOne(fetch=FetchType.LAZY)
	private Projet projet;
    
    
       
    
	public FinancementEtranger( String code, String libelle, Devise devise,
			Pays pays_financement,String pays_geocoordinates, Float montant_dt, Float montant_actualise, Date date_actualisation, Financeur financeur,
			Date date_signature, Date date_debut, Date date_cloture, Date date_delai, Projet projet) {
		this.code = code;
		this.libelle = libelle;
		this.devise = devise;
		this.pays_financement=pays_financement;
		this.pays_geocoordinates=pays_geocoordinates;
		this.montant_dt = montant_dt;
		this.montant_actualise = montant_actualise;
		this.date_actualisation = date_actualisation;
		this.financeur = financeur;
		this.date_signature = date_signature;
		this.date_debut = date_debut;
		this.date_cloture = date_cloture;
		this.date_delai = date_delai;
		this.projet = projet;
	}
	
	public FinancementEtranger() {
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
	
	
	
	@Column(name = "devise", nullable = false)
	public Devise getDevise() {
		return devise;
	}
	public void setDevise(Devise devise) {
		this.devise = devise;
	}
	

	
	@Column(name = "pays_financement", nullable = false)
	public Pays getPays_financement() {
		return pays_financement;
	}

	public void setPays_financement(Pays pays_financement) {
		this.pays_financement = pays_financement;
	}
	
	
	@Column(name = "pays_geocoordinates", nullable = false)
	public String getPays_geocoordinates() {
		return pays_geocoordinates;
	}

	public void setPays_geocoordinates(String pays_geocoordinates) {
		this.pays_geocoordinates = pays_geocoordinates;
	}

	@Column(name = "montant_dt", nullable = false)
	public Float getMontant_dt() {
		return montant_dt;
	}
	public void setMontant_dt(Float montant_dt) {
		this.montant_dt = montant_dt;
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
	
	@Column(name = "financeur", nullable = false)
	public Financeur getFinanceur() {
		return financeur;
	}
	public void setFinanceur(Financeur financeur) {
		this.financeur = financeur;
	}
	
	@Column(name = "date_signature", nullable = false)
	public Date getDate_signature() {
		return date_signature;
	}
	public void setDate_signature(Date date_signature) {
		this.date_signature = date_signature;
	}
	
	
	@Column(name = "date_debut", nullable = false)
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	
	@Column(name = "date_cloture", nullable = false)
	public Date getDate_cloture() {
		return date_cloture;
	}
	public void setDate_cloture(Date date_cloture) {
		this.date_cloture = date_cloture;
	}
	
	@Column(name = "date_delai", nullable = false)
	public Date getDate_delai() {
		return date_delai;
	}
	public void setDate_delai(Date date_delai) {
		this.date_delai = date_delai;
	}
	
	@Column(name = "projet_code", nullable = false)
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
    
    
    
}