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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "secteur")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Secteur {
	@Id
	@Enumerated(EnumType.STRING)
    private TypeSecteur type_secteur;
    @OneToMany(mappedBy ="secteur", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
    @JsonIgnore
    private List<Projet> projets = new ArrayList<Projet>();
    
    
    
    
    public Secteur(TypeSecteur type_secteur, List<Projet> projets) {
		
	
		this.type_secteur = type_secteur;
		this.projets = projets;
	}
    
    
    public Secteur() {
    	
    }
    

	
	
	@Column(name = "type_secteur", nullable = false)
	public TypeSecteur getType_secteur() {
		return type_secteur;
	}
	public void setType_secteur(TypeSecteur type_secteur) {
		this.type_secteur = type_secteur;
	}
	
	
	public List<Projet> getProjets() {
		return projets;
	}
	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
    
    
    
	

}
