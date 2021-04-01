package tn.cni.injez.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "etablissement")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Etablissement {
	@Id
	private String code;
	private String nom;
	private Gouvernorat adresse;
	private String adresse_geocoordinates;
	private String num_telephone;
    @OneToMany(mappedBy ="etablissement", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
    @JsonIgnore
    private List<Projet> projets = new ArrayList<Projet>();
    @OneToMany(mappedBy ="etablissement", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
    @JsonIgnore
    private List<Utilisateur> users = new ArrayList<Utilisateur>();
   
   
public Etablissement(String code, String nom, Gouvernorat adresse,String adresse_geocoordinates, String num_telephone, List<Projet> projets) {

	this.code = code;
	this.nom = nom;
	this.adresse = adresse;
	this.adresse_geocoordinates=adresse_geocoordinates;
	this.num_telephone = num_telephone;
	this.projets = projets;
}
	  

	 public Etablissement () {
		 
	 }


	 @Column(name = "code", nullable = false)
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "nom", nullable = false)
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "adresse", nullable = false)
	public Gouvernorat getAdresse() {
		return adresse;
	}


	public void setAdresse(Gouvernorat adresse) {
		this.adresse = adresse;
	}
	
	
	
	@Column(name = "adresse_geocoordinates", nullable = false)
	public String getAdresse_geocoordinates() {
		return adresse_geocoordinates;
	}


	public void setAdresse_geocoordinates(String adresse_geocoordinates) {
		this.adresse_geocoordinates = adresse_geocoordinates;
	}


	@Column(name = "num_telephone", nullable = false)
	public String getNum_telephone() {
		return num_telephone;
	}


	public void setNum_telephone(String num_telephone) {
		this.num_telephone = num_telephone;
	}

	
	public List<Projet> getProjets() {
		return projets;
	}


	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
	
	
	public List<Utilisateur> getUsers() {
		return users;
	}


	public void setUsers(List<Utilisateur> users) {
		this.users = users;
	}
	  


}
