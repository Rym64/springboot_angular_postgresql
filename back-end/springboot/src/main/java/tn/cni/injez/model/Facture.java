package tn.cni.injez.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.sql.Date;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "facture")
public class Facture {
	@Id
	private String code;
	private Date date_facture;
	private Float montant;
	private Float montant_paye;
	private Date date_payement;
	@ManyToOne(fetch=FetchType.LAZY)
	private Marche marche;
	
    
	public Facture(String code, Date date_facture, Float montant, Float montant_paye,
			Date date_payement,Marche marche) 
	{
		this.code = code;
		this.date_facture = date_facture;
		this.montant = montant;
		this.montant_paye = montant_paye;
		this.date_payement = date_payement;
		this.marche=marche;
	}
	
	public Facture() {
		
	}
	
	

	
	
	
	@Column(name = "code", nullable = false)

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	@Column(name = "date_facture", nullable = false)

	public Date getDate_facture() {
		return date_facture;
	}

	public void setDate_facture(Date date_facture) {
		this.date_facture = date_facture;
	}
	
	
	
	@Column(name = "montant", nullable = false)

	public Float getMontant() {
		return montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}
	
	
	
	
	@Column(name = "montant_paye", nullable = false)

	public Float getMontant_paye() {
		return montant_paye;
	}

	public void setMontant_paye(Float montant_paye) {
		this.montant_paye = montant_paye;
	}
	
	
	
	
	@Column(name = "date_payement", nullable = false)

	public Date getDate_payement() {
		return date_payement;
	}
	public void setDate_payement(Date date_payement) {
		this.date_payement = date_payement;
	}



	@Column(name = "marche_code", nullable = false)

	public Marche getMarche() {
		return marche;
	}

	public void setMarche(Marche marche) {
		this.marche = marche;
	}
	
	
	
	
	

}
