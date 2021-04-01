package tn.cni.injez.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import tn.cni.injez.response.Response;
import tn.cni.injez.model.Profil;
import tn.cni.injez.model.Projet;
import tn.cni.injez.model.Utilisateur;
import tn.cni.injez.model.UtilisateurProfilProjet;

public interface UtilisateurService {

	int LoginUser (Utilisateur user);
	int LoginAdmin (Utilisateur admin);
	int LoginAdminCni (Utilisateur admin_cni);
	void Logout ();
	Utilisateur ajouterUtilisateur(Utilisateur user);
	List<Utilisateur> afficherUtilisateurs();
	List<UtilisateurProfilProjet> findProjectsAndProfilesOfUser();
	
	Utilisateur modifierUtilisateur(Utilisateur user);

	HttpStatus supprimerUtilisateur(String username);
	List<Utilisateur> utilisateurCourant();
	List<Utilisateur> searchUtilisateur(String recherche);
	Profil profilCourant(String project);

}
