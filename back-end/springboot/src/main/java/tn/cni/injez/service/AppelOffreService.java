package tn.cni.injez.service;

import java.util.List;

import tn.cni.injez.model.AppelOffre;

public interface AppelOffreService {
	List<AppelOffre> afficherAppelsOffre();
	List<AppelOffre> findAppelsOffreByProject();
	AppelOffre ajouterAppelOffre(AppelOffre appelOffre);
	AppelOffre modifierAppelOffre(AppelOffre appelOffre);
	void supprimerAppelOffre(String code);
	AppelOffre findById(String code);
	List<AppelOffre> appelOffreCourant();
	List<AppelOffre> searchAppelOffre(String recherche);
}
