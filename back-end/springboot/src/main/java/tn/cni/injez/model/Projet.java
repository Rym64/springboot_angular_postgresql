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
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "project")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Projet {
	
	@Id
    private String code;
    private String libelle;    
    private String description;
    private Date date_debut;
    private Date date_debut_actualisee;
    private Date date_fin;
    private Date date_fin_actualisee;
    private Float cout;
    private Float cout_actualise;
    private Gouvernorat lieu_projet;
    private String lieu_geocoordinate;
    private String stade;
    private String flag;
    private String code_financement_public;
    private String libelle_financement_public;
    private Date date_financement_public;
	private Float montant_financement_public;
	private Float montant_financement_public_actualise;
	private Date date_actualisation_financement_public;
    private int current=0;
    @ManyToOne(fetch=FetchType.LAZY)
    private Etablissement etablissement;
    @ManyToOne(fetch=FetchType.LAZY)
    private Secteur secteur;
    @OneToMany(mappedBy ="projet", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
    @JsonIgnore
    private List<Decomposition> decompositions=new ArrayList<Decomposition>();  
    @OneToMany(mappedBy ="projet", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
    @JsonIgnore
    private List<FinancementEtranger> financements_etranger = new ArrayList<FinancementEtranger>();
    @OneToMany(mappedBy ="projet", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
    @JsonIgnore
    private List<AutreFinancement> autre_financements = new ArrayList<AutreFinancement>();
    @OneToMany(mappedBy ="projet", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
    @JsonIgnore
    private List<AppelOffre> appels_offre = new ArrayList<AppelOffre>();
    @OneToMany(mappedBy ="projet", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
    @JsonIgnore
    private List<Objectif> objectifs = new ArrayList<Objectif>();
    @OneToMany(mappedBy = "projet", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY)
    private List<UtilisateurProfilProjet> UtilisateursProfilsProjets=new ArrayList<UtilisateurProfilProjet>();
    







	public Projet(String code, String libelle, String description, Date date_debut, Date date_debut_actualisee,
			Date date_fin, Date date_fin_actualisee, Float cout, Float cout_actualise, Gouvernorat lieu_projet,
			String lieu_geocoordinate, String stade, String flag, String code_financement_public,
			String libelle_financement_public, Date date_financement_public, Float montant_financement_public,
			Float montant_financement_public_actualise, Date date_actualisation_financement_public, int current,
			Etablissement etablissement, Secteur secteur, List<Decomposition> decompositions,
			List<FinancementEtranger> financements_etranger, List<AutreFinancement> autre_financements,
			List<AppelOffre> appels_offre, List<Objectif> objectifs,
			List<UtilisateurProfilProjet> utilisateursProfilsProjets) {
		
		this.code = code;
		this.libelle = libelle;
		this.description = description;
		this.date_debut = date_debut;
		this.date_debut_actualisee = date_debut_actualisee;
		this.date_fin = date_fin;
		this.date_fin_actualisee = date_fin_actualisee;
		this.cout = cout;
		this.cout_actualise = cout_actualise;
		this.lieu_projet = lieu_projet;
		this.lieu_geocoordinate = lieu_geocoordinate;
		this.stade = stade;
		this.flag = flag;
		this.code_financement_public = code_financement_public;
		this.libelle_financement_public = libelle_financement_public;
		this.date_financement_public = date_financement_public;
		this.montant_financement_public = montant_financement_public;
		this.montant_financement_public_actualise = montant_financement_public_actualise;
		this.date_actualisation_financement_public = date_actualisation_financement_public;
		this.current = current;
		this.etablissement = etablissement;
		this.secteur = secteur;
		this.decompositions = decompositions;
		this.financements_etranger = financements_etranger;
		this.autre_financements = autre_financements;
		this.appels_offre = appels_offre;
		this.objectifs = objectifs;
		UtilisateursProfilsProjets = utilisateursProfilsProjets;
	}





	public Projet() {
		
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


	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "date_debut", nullable = false)
	public Date getDate_debut() {
		return date_debut;
	}



	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}


	@Column(name = "date_debut_actualisee")
	public Date getDate_debut_actualisee() {
		return date_debut_actualisee;
	}



	public void setDate_debut_actualisee(Date date_debut_actualisee) {
		this.date_debut_actualisee = date_debut_actualisee;
	}


	@Column(name = "date_fin", nullable = false)
	public Date getDate_fin() {
		return date_fin;
	}



	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}


	@Column(name = "date_fin_actualisee")
	public Date getDate_fin_actualisee() {
		return date_fin_actualisee;
	}



	public void setDate_fin_actualisee(Date date_fin_actualisee) {
		this.date_fin_actualisee = date_fin_actualisee;
	}


	@Column(name = "cout", nullable = false)
	public Float getCout() {
		return cout;
	}



	public void setCout(Float cout) {
		this.cout = cout;
	}

	@Column(name = "cout_actualise")
	public Float getCout_actualise() {
		return cout_actualise;
	}



	public void setCout_actualise(Float cout_actualise) {
		this.cout_actualise = cout_actualise;
	}
	

	
	@Column(name = "lieu_projet", nullable = false)
	
	public Gouvernorat getLieu_projet() {
		return lieu_projet;
	}



	public void setLieu_projet(Gouvernorat lieu_projet) {
		this.lieu_projet = lieu_projet;
	}


	
	
	@Column(name = "lieu_geocoordinate", nullable = false)
	public String getLieu_geocoordinate() {
		return lieu_geocoordinate;
	}





	public void setLieu_geocoordinate(String lieu_geocoordinate) {
		this.lieu_geocoordinate = lieu_geocoordinate;
	}





	@Column(name = "stade", nullable = false)
	public String getStade() {
		return stade;
	}



	public void setStade(String stade) {
		this.stade = stade;
	}


	@Column(name = "flag", nullable = false)

	public String getFlag() {
		return flag;
	}



	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	
	@Column(name = "code_financement_public", nullable = false)
	
	public String getCode_financement_public() {
		return code_financement_public;
	}





	public void setCode_financement_public(String code_financement_public) {
		this.code_financement_public = code_financement_public;
	}


	@Column(name = "libelle_financement_public", nullable = false)

	public String getLibelle_financement_public() {
		return libelle_financement_public;
	}





	public void setLibelle_financement_public(String libelle_financement_public) {
		this.libelle_financement_public = libelle_financement_public;
	}




	@Column(name = "date_financement_public", nullable = false)
	public Date getDate_financement_public() {
		return date_financement_public;
	}





	public void setDate_financement_public(Date date_financement_public) {
		this.date_financement_public = date_financement_public;
	}





	@Column(name = "montant_financement_public", nullable = false)

	public Float getMontant_financement_public() {
		return montant_financement_public;
	}





	public void setMontant_financement_public(Float montant_financement_public) {
		this.montant_financement_public = montant_financement_public;
	}



	@Column(name = "montant_financement_public_actualise")

	public Float getMontant_financement_public_actualise() {
		return montant_financement_public_actualise;
	}





	public void setMontant_financement_public_actualise(Float montant_financement_public_actualise) {
		this.montant_financement_public_actualise = montant_financement_public_actualise;
	}



	@Column(name = "date_actualisation_financement_public")

	public Date getDate_actualisation_financement_public() {
		return date_actualisation_financement_public;
	}





	public void setDate_actualisation_financement_public(Date date_actualisation_financement_public) {
		this.date_actualisation_financement_public = date_actualisation_financement_public;
	}



	





	@Column(name = "current", nullable = false)
	public int getCurrent() {
		return current;
	}



	public void setCurrent(int current) {
		this.current = current;
	}


	@Column(name = "etablissement_code", nullable = false)
	
	public Etablissement getEtablissement() {
		return etablissement;
	}





	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}





	@Column(name = "secteur_type_secteur", nullable = false)
	public Secteur getSecteur() {
		return secteur;
	}



	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}





	public List<Decomposition> getDecompositions() {
		return decompositions;
	}

	public void setDecompositions(List<Decomposition> decompositions) {
		this.decompositions = decompositions;
	}




	





	public List<FinancementEtranger> getFinancements_etranger() {
		return financements_etranger;
	}

	public void setFinancements_etranger(List<FinancementEtranger> financements_etranger) {
		this.financements_etranger = financements_etranger;
	}





	public List<AutreFinancement> getAutre_financements() {
		return autre_financements;
	}

	public void setAutre_financements(List<AutreFinancement> autre_financements) {
		this.autre_financements = autre_financements;
	}




	@JsonIgnore
	public List<AppelOffre> getAppels_offre() {
		return appels_offre;
	}





	public void setAppels_offre(List<AppelOffre> appels_offre) {
		this.appels_offre = appels_offre;
	}





	public List<Objectif> getObjectifs() {
		return objectifs;
	}





	public void setObjectifs(List<Objectif> objectifs) {
		this.objectifs = objectifs;
	}


    @JsonIgnore
	public List<UtilisateurProfilProjet> getUtilisateursProfilsProjets() {
		return UtilisateursProfilsProjets;
	}





	public void setUtilisateursProfilsProjets(List<UtilisateurProfilProjet> utilisateursProfilsProjets) {
		UtilisateursProfilsProjets = utilisateursProfilsProjets;
	}




	




	
	
}
