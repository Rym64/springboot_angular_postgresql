package tn.cni.injez.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import tn.cni.injez.configuration.TypeProfilConverter;


@Entity
@Table(name = "profil")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Profil {

	@Id
	private String id;
	private TypeProfil type_profil;
    @OneToMany(mappedBy = "profil", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY)
    private List<UtilisateurProfilProjet> UtilisateursProfilsProjets=new ArrayList<UtilisateurProfilProjet>();


	
	public Profil(String id,TypeProfil type_profil) {
		this.id=id;
		this.type_profil = type_profil;
		
	}


	public Profil() {
		
	}

	
	@Column(name = "id", nullable = false)
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Column(name = "type_profil", nullable = false)
	public TypeProfil getType_profil() {
		return type_profil;
	}

	public void setType_profil(TypeProfil type_profil) {
		this.type_profil = type_profil;
	}

    @JsonIgnore
	public List<UtilisateurProfilProjet> getUtilisateursProfilsProjets() {
		return UtilisateursProfilsProjets;
	}

	public void setUtilisateursProfilsProjets(List<UtilisateurProfilProjet> utilisateursProfilsProjets) {
		UtilisateursProfilsProjets = utilisateursProfilsProjets;
	}
	
	
    
    
	

}
