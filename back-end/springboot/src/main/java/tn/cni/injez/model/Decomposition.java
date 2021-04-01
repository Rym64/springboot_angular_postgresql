package tn.cni.injez.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.sql.Date;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "decomposition")
public class Decomposition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String code;
	private String libelle;
	private Float montant;
	private Date date_debut;
	private Date date_debut_actualisee;
	private Date date_fin;
	private Date date_fin_actualisee;
	@Enumerated(EnumType.STRING)
	private TypeDecomposition type_decomposition;
	private String decomposition_mere;
	private Integer niveau_decomposition;
	private int degres_decomposition=0;	
	@ManyToOne(fetch=FetchType.LAZY)
	
	private Projet projet;
	    
		public Decomposition(Integer id,String code, String libelle, Float montant,
				Date date_debut,Date date_debut_actualisee,Date date_fin,Date date_fin_actualisee,TypeDecomposition type_decomposition,String decomposition_mere,Integer niveau_decomposition,int degres_decomposition,Projet projet) 
		{
			this.id = id;
			this.code = code;
			this.libelle = libelle;
			this.montant = montant;
			this.date_debut=date_debut;
			this.date_debut_actualisee=date_debut_actualisee;
			this.date_fin=date_fin;
			this.date_fin_actualisee=date_fin_actualisee;
			this.type_decomposition=type_decomposition;
			this.decomposition_mere=decomposition_mere;
			this.niveau_decomposition=niveau_decomposition;
			this.degres_decomposition=degres_decomposition;
			this.projet=projet;
		}
		
		public Decomposition() {
			
		}
		
		

	
		
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
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
		
		
		
		@Column(name = "montant", nullable = false)

		public Float getMontant() {
			return montant;
		}

		public void setMontant(Float montant) {
			this.montant = montant;
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

		@Column(name = "dat_fin", nullable = false)
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
		
		
		@Column(name = "type_decomposition", nullable = false)
		public TypeDecomposition getType_decomposition() {
			return type_decomposition;
		}

		public void setType_decomposition(TypeDecomposition type_decomposition) {
			this.type_decomposition = type_decomposition;
		}
		
		@Column(name = "decomposition_mere", nullable = false)

		public String getDecomposition_mere() {
			return decomposition_mere;
		}

		public void setDecomposition_mere(String decomposition_mere) {
			this.decomposition_mere = decomposition_mere;
		}
		
		@Column(name = "niveau_decomposition", nullable = false)
		public Integer getNiveau_decomposition() {
			return niveau_decomposition;
		}

		public void setNiveau_decomposition(Integer niveau_decomposition) {
			this.niveau_decomposition = niveau_decomposition;
		}
		
		
		
		@Column(name = "degres_decomposition", nullable = false)
		public int getDegres_decomposition() {
			return degres_decomposition;
		}

		public void setDegres_decomposition(int degres_decomposition) {
			this.degres_decomposition = degres_decomposition;
		}


		
		@Column(name = "projet_code", nullable = false)

		public Projet getProjet() {
			return projet;
		}

		public void setProjet(Projet projet) {
			this.projet = projet;
		}

}
