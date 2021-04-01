package tn.cni.injez.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "marche")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Marche {
	@Id
    private String code;
	private String libelle;
	private String fournisseur;
	private Devise devise;
	private Pays pays_marche;
	private String pays_geocoordinates;
	private Float montant_dt;
	private Float montant_actualise;
	private Date date_signature;
	private Integer periode_travail;
	private Date date_fin_travaux_estimee;
	private Date date_fin_travaux_reelle;
	private Float niveau;
	@ManyToOne(fetch=FetchType.LAZY)
    private LotAppelOffre lot_appel_offre;
	private int current=0;
    @OneToMany(mappedBy ="marche", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Facture> factures = new ArrayList<Facture>();
    
	
	
	public Marche(String code, String libelle, String fournisseur, Devise devise,
			Pays pays_marche,String pays_geocoordinates, Float montant_dt, Float montant_actualise,
			Date date_signature, Integer periode_travail, Date date_fin_travaux_estimee, Date date_fin_travaux_reelle,
			Float niveau, LotAppelOffre lot_appel_offre, int current,List<Facture> factures) {
		this.code = code;
		this.libelle = libelle;
		this.fournisseur = fournisseur;
		this.devise = devise;
		this.pays_marche = pays_marche;
		this.pays_geocoordinates=pays_geocoordinates;
		this.montant_dt = montant_dt;
		this.montant_actualise = montant_actualise;
		this.date_signature = date_signature;
		this.periode_travail = periode_travail;
		this.date_fin_travaux_estimee = date_fin_travaux_estimee;
		this.date_fin_travaux_reelle = date_fin_travaux_reelle;
		this.niveau = niveau;
		this.lot_appel_offre = lot_appel_offre;
		this.current = current;
		this.factures = factures;
	}
	
	public Marche () {
		
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

	@Column(name = "fournisseur", nullable = false)
	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	

	@Column(name = "devise", nullable = false)
	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}
	
	
	

	
	@Column(name = "pays_marche", nullable = false)
	public Pays getPays_marche() {
		return pays_marche;
	}

	public void setPays_marche(Pays pays_marche) {
		this.pays_marche = pays_marche;
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

	

	@Column(name = "date_signature", nullable = false)
	public Date getDate_signature() {
		return date_signature;
	}

	public void setDate_signature(Date date_signature) {
		this.date_signature = date_signature;
	}

	@Column(name = "periode_travail", nullable = false)
	public Integer getPeriode_travail() {
		return periode_travail;
	}

	public void setPeriode_travail(Integer periode_travail) {
		this.periode_travail = periode_travail;
	}

	@Column(name = "date_fin_travaux_estimee", nullable = false)
	public Date getDate_fin_travaux_estimee() {
		return date_fin_travaux_estimee;
	}

	public void setDate_fin_travaux_estimee(Date date_fin_travaux_estimee) {
		this.date_fin_travaux_estimee = date_fin_travaux_estimee;
	}

	@Column(name = "date_fin_travaux_reelle", nullable = false)
	public Date getDate_fin_travaux_reelle() {
		return date_fin_travaux_reelle;
	}

	public void setDate_fin_travaux_reelle(Date date_fin_travaux_reelle) {
		this.date_fin_travaux_reelle = date_fin_travaux_reelle;
	}

	@Column(name = "niveau", nullable = false)
	public Float getNiveau() {
		return niveau;
	}

	public void setNiveau(Float niveau) {
		this.niveau = niveau;
	}

	@Column(name = "lot_appel_offre_code", nullable = false)
	public LotAppelOffre getLot_appel_offre() {
		return lot_appel_offre;
	}

	public void setLot_appel_offre(LotAppelOffre lot_appel_offre) {
		this.lot_appel_offre = lot_appel_offre;
	}

	@Column(name = "current", nullable = false)
	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	
	
	
	
	
	

}
