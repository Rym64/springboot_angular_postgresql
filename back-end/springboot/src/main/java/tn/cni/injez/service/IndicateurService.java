package tn.cni.injez.service;

import java.util.List;

import tn.cni.injez.model.Indicateur;

public interface IndicateurService {
	List<Indicateur> afficherIndicateurs();
	List<Indicateur> findIndicateursByObjectif();
	Indicateur ajouterIndicateur(Indicateur indicateur);
	Indicateur modifierIndicateur(Indicateur indicateur);
	void supprimerIndicateur(String code);
	List<Indicateur> searchIndicateur(String recherche);

}
