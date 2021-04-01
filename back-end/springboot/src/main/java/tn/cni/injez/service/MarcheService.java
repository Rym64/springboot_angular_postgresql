package tn.cni.injez.service;

import java.util.List;

import tn.cni.injez.model.Marche;

public interface MarcheService {
	List<Marche> afficherMarches();
	List<Marche> findMarchesByAppelOffre();
	Marche findMarcheById(String code);
	Marche ajouterMarche(Marche marche);
	Marche modifierMarche(Marche marche);
	void supprimerMarche(String code);
	List<Marche> marcheCourant();
	List<Marche> searchMarche(String recherche);
}
