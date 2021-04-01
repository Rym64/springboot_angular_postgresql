package tn.cni.injez.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
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

import tn.cni.injez.configuration.TypeLotConverter;


@Entity
@Table(name = "lot_appel_offre")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class LotAppelOffre {
    @Id
	private String code;
	private TypeLotAppelOffre type_lot;
	private Date date_lot;
	private Float montant;
	private int current=0;
	@ManyToOne(fetch=FetchType.LAZY)
	private AppelOffre appel_offre;
    @OneToMany(mappedBy ="lot_appel_offre", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
	@JsonIgnore
	private List<Marche> marches = new ArrayList<Marche>();
	
	public LotAppelOffre(String code, TypeLotAppelOffre type_lot,Date date_lot, Float montant, int current, AppelOffre appel_offre,
			List<Marche> marches) {
		
		this.code = code;
		this.type_lot = type_lot;
		this.date_lot = date_lot;
		this.montant = montant;
		this.current = current;
		this.appel_offre = appel_offre;
		this.marches = marches;
	}
	
	
	public LotAppelOffre() {
		
	}


	@Column(name = "code", nullable = false)
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	@Column(name = "type_lot", nullable = false)
	public TypeLotAppelOffre getType_lot() {
		return type_lot;
	}


	public void setType_lot(TypeLotAppelOffre type_lot) {
		this.type_lot = type_lot;
	}


	@Column(name = "date_lot", nullable = false)
	public Date getDate_lot() {
		return date_lot;
	}


	public void setDate_lot(Date date_lot) {
		this.date_lot = date_lot;
	}


	@Column(name = "montant", nullable = false)
	public Float getMontant() {
		return montant;
	}


	public void setMontant(Float montant) {
		this.montant = montant;
	}


	@Column(name = "current", nullable = false)
	public int getCurrent() {
		return current;
	}


	public void setCurrent(int current) {
		this.current = current;
	}


	@Column(name = "appel_offre_code", nullable = false)
	public AppelOffre getAppel_offre() {
		return appel_offre;
	}


	public void setAppel_offre(AppelOffre appel_offre) {
		this.appel_offre = appel_offre;
	}


	public List<Marche> getMarches() {
		return marches;
	}


	public void setMarches(List<Marche> marches) {
		this.marches = marches;
	}
	
	
	
	
	
	
}
