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
@Table(name = "appel_offre")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class AppelOffre {
	@Id
	private String code;
	private String libelle;
	private Date date_appel_offre;
	private Float montant_estime;
	private Float montant_actualise;
	private Date date_actualisation;
	private EtatAppelOffre etat;
	private int current=0;
	@ManyToOne(fetch=FetchType.LAZY)
	
	private Projet projet;
    @OneToMany(mappedBy ="appel_offre", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
    @JsonIgnore
    private List<LotAppelOffre> lots_appel_offre = new ArrayList<LotAppelOffre>();

	
    
	public AppelOffre( String code, String libelle,Date date_appel_offre, Float montant_estime, Float montant_actualise,
			Date date_actualisation,EtatAppelOffre etat,int current,Projet projet,List<LotAppelOffre> lots_appel_offre) 
	{
		this.code = code;
		this.libelle = libelle;
		this.date_appel_offre = date_appel_offre;
		this.montant_estime = montant_estime;
		this.montant_actualise = montant_actualise;
		this.date_actualisation = date_actualisation;
		this.etat=etat;
		this.current=current;
		this.projet=projet;
		this.lots_appel_offre = lots_appel_offre;
	}
	
	public AppelOffre() {
		
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
	
	
	
	@Column(name = "date_appel_offre", nullable = false)
	
	public Date getDate_appel_offre() {
		return date_appel_offre;
	}

	public void setDate_appel_offre(Date date_appel_offre) {
		this.date_appel_offre = date_appel_offre;
	}

	@Column(name = "montant_estime", nullable = false)

	public Float getMontant_estime() {
		return montant_estime;
	}

	public void setMontant_estime(Float montant_estime) {
		this.montant_estime = montant_estime;
	}
	
	
	
	
	@Column(name = "montant_actualise", nullable = false)

	public Float getMontant_actualise() {
		return montant_actualise;
	}

	public void setMontant_actualise(Float montant_actualise) {
		this.montant_actualise = montant_actualise;
	}
	
	
	
	
	@Column(name = "date_actualisation", nullable = false)

	public Date getDate_actualisation() {
		return date_actualisation;
	}
	public void setDate_actualisation(Date date_actualisation) {
		this.date_actualisation = date_actualisation;
	}

	@Column(name = "Etat", nullable = false)

	public EtatAppelOffre getEtat() {
		return etat;
	}

	public void setEtat(EtatAppelOffre etat) {
		this.etat = etat;
	}
	
	

	@Column(name = "current", nullable = false)

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	@Column(name = "projet_code", nullable = false)
	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<LotAppelOffre> getLots_appel_offre() {
		return lots_appel_offre;
	}

	public void setLots_appel_offre(List<LotAppelOffre> lots_appel_offre) {
		this.lots_appel_offre = lots_appel_offre;
	}


	
	


	
	
	
	

}
