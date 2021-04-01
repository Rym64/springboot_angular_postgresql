package tn.cni.injez.service;

import java.util.List;

import tn.cni.injez.model.Objectif;

public interface ObjectifService {
	List<Objectif> afficherObjectifs();
	List<Objectif> findObjectifsByProject();
	Objectif ajouterObjectif(Objectif objectif);
	Objectif modifierObjectif(Objectif objectif);
	void supprimerObjectif(String code);
	List<Objectif> searchObjectif(String recherche);
	List<Objectif> objectifCourant();

}
