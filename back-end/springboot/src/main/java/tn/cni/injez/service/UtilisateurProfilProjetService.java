package tn.cni.injez.service;

import java.util.List;

import tn.cni.injez.model.UtilisateurProfilProjet;

public interface UtilisateurProfilProjetService {
	List<UtilisateurProfilProjet> afficherUtilisateursProfilsProjets();
	List<UtilisateurProfilProjet> findUtilisateursProfilsProjets();
	UtilisateurProfilProjet findById(Integer id);
	UtilisateurProfilProjet ajouterUtilisateurProfilProjet(UtilisateurProfilProjet utilisateurProfilProjet);
	UtilisateurProfilProjet modifierUtilisateurProfilProjet(UtilisateurProfilProjet utilisateurProfilProjet);
	void supprimerUtilisateurProfilProjet(Integer id);
	List<UtilisateurProfilProjet> searchUtilisateurProfilProjet(String recherche);

}
