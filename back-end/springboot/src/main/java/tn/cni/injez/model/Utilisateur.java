package tn.cni.injez.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.sql.Date;
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
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Utilisateur{
	@Id
	private String username;
    private String name;
    private String last_name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    private Date date_naissance;
    private Gouvernorat adresse;
    private String adresse_geocoordinate;
    private Role role;
    private String fileName;
    private int logged=0;
    @ManyToOne(fetch=FetchType.LAZY)
    private Etablissement etablissement;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<UtilisateurProfilProjet> UtilisateursProfilsProjets=new ArrayList<UtilisateurProfilProjet>();
   
    
    

   



	public Utilisateur(String username, String name, String last_name, String email, String password, Sexe sexe,
			Date date_naissance, Gouvernorat adresse,String adresse_geocoordinate, Role role, String fileName, int logged, Etablissement etablissement,List<UtilisateurProfilProjet> UtilisateursProfilsProjets) {
		this.username = username;
		this.name = name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.sexe = sexe;
		this.date_naissance = date_naissance;
		this.adresse = adresse;
		this.adresse_geocoordinate=adresse_geocoordinate;
		this.role = role;
		this.fileName = fileName;
		this.logged = logged;
		this.etablissement = etablissement;
		this.UtilisateursProfilsProjets=UtilisateursProfilsProjets;
	}




	public Utilisateur() {}

   


	@Column(name = "username", nullable = false)

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
	@Column(name = "name", nullable = false)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "last_name", nullable = false)

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    
    
    @Column(name = "email", nullable = false)

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
	@Column(name = "password", nullable = false)

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name = "sexe", nullable = false)

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }
    
    
@Column(name = "date_naissance", nullable = false)

    
	public Date getDate_naissance() {
		return date_naissance;
	}



	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	
	
	@Column(name = "adresse", nullable = false)

    
	public Gouvernorat getAdresse() {
		return adresse;
	}



	public void setAdresse(Gouvernorat adresse) {
		this.adresse = adresse;
	}


	
	@Column(name = "adresse_geocoordinate", nullable = false)

	
	public String getAdresse_geocoordinate() {
		return adresse_geocoordinate;
	}




	public void setAdresse_geocoordinate(String adresse_geocoordinate) {
		this.adresse_geocoordinate = adresse_geocoordinate;
	}




	@Column(name = "role", nullable = false)

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
   
    
    
    @Column(name = "fileName", nullable = false)
    
    public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	@Column(name = "isLogged")

    public int getLogged() {
        return logged;
    }

    public void setLogged(int logged) {
        this.logged = logged;
    }


    @Column(name = "etablissement")
	public Etablissement getEtablissement() {
		return etablissement;
	}



	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}



	@JsonIgnore
	public List<UtilisateurProfilProjet> getUtilisateursProfilsProjets() {
		return UtilisateursProfilsProjets;
	}




	public void setUtilisateursProfilsProjets(List<UtilisateurProfilProjet> utilisateursProfilsProjets) {
		UtilisateursProfilsProjets = utilisateursProfilsProjets;
	}
    
    
    
   
}