package tn.cni.injez.service;

import java.util.List;

import tn.cni.injez.model.LotAppelOffre;

public interface LotAppelOffreService {
	List<LotAppelOffre> afficherLotsAppelOffre();
	List<LotAppelOffre> findLotsAppelOffreByAppelOffre();
	LotAppelOffre findById(String code);
	LotAppelOffre ajouterLotAppelOffre(LotAppelOffre lotAppelOffre);
	LotAppelOffre modifierLotAppelOffre(LotAppelOffre lotAppelOffre);
	void supprimerLotAppelOffre(String code);
	List<LotAppelOffre> lotAppelOffreCourant();
	List<LotAppelOffre> searchLotAppelOffre(String recherche);

}
