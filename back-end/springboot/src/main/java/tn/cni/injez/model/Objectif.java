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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "objectif")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Objectif {
	@Id
    private String code;
	private String libelle;
	@Enumerated(EnumType.STRING)
	private TypeObjectif type_objectif;
	private String description;
	private int current=0;
	@ManyToOne(fetch=FetchType.LAZY)
    private Projet projet;
    @OneToMany(mappedBy ="objectif", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
	 @JsonIgnore
	private List<Indicateur> indicateurs=new ArrayList<Indicateur>();  
	
	public Objectif(String code, String libelle,TypeObjectif type_objectif, String description,int current, Projet projet,List<Indicateur> indicateurs) {
		
		this.code = code;
		this.libelle = libelle;
		this.type_objectif = type_objectif;
		this.description = description;
		this.current=current;
		this.projet = projet;
		this.indicateurs=indicateurs;
	}
	
	public Objectif ()
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

	@Column(name = "type_objectif", nullable = false)
	public TypeObjectif getType_objectif() {
		return type_objectif;
	}

	public void setType_objectif(TypeObjectif type_objectif) {
		this.type_objectif = type_objectif;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
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

	public List<Indicateur> getIndicateurs() {
		return indicateurs;
	}

	public void setIndicateurs(List<Indicateur> indicateurs) {
		this.indicateurs = indicateurs;
	}
	
	
	
	
	

}
