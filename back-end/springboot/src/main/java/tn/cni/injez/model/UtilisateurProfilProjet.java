package tn.cni.injez.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "utilisateur_profil_projet")
public class UtilisateurProfilProjet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Utilisateur user;

	@ManyToOne(fetch=FetchType.LAZY)
	private Profil profil;

	@ManyToOne(fetch=FetchType.LAZY)
	private Projet projet;

	public UtilisateurProfilProjet(Utilisateur user, Profil profil, Projet projet) {

		this.user = user;
		this.profil = profil;
		this.projet = projet;
	}

	public UtilisateurProfilProjet() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_username", nullable = false)
	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	@Column(name = "profil_id", nullable = false)
	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	@Column(name = "projet_code", nullable = false)
	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

}
