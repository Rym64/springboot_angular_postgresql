package com.stagepfe.cni.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(	name = "permis")
public class Permis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String code_permis;
	
	@Column(name = "gouvernorat")
	private String gouvernorat;
	
	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "permis_demande", 
				joinColumns = @JoinColumn(name = "permis_id"), 
				inverseJoinColumns = @JoinColumn(name = "demande_id"))
	private Set<Demande> demande = new HashSet<>();*/

	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	
	public Permis() {
		
	}

	public Permis(String code_permis, String gouvernorat) {
		this.code_permis = code_permis;
		this.gouvernorat = gouvernorat;
	}

	public String getCode_permis() {
		return code_permis;
	}

	public void setCode_permis(String code_permis) {
		this.code_permis = code_permis;
	}

	public String getGouvernorat() {
		return gouvernorat;
	}

	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*public Set<Demande> getDemande() {
		return demande;
	}

	public void setDemande(Set<Demande> demande) {
		this.demande = demande;
	}*/
	
	
}
