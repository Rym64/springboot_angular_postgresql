package tn.cni.injez.service;

import java.util.List;

import tn.cni.injez.model.Projet;

public interface ProjetService {
	List<Projet> afficherProjets();
	Projet ajouterProjet(Projet projet);
	Projet modifierProjet(Projet projet);
	void supprimerProjet(String code);
	Projet findByCode(String code);
	List<Projet> projetCourant();
	List<Projet> searchProjet(String recherche);
}
