package tn.cni.injez.service;

import java.util.List;

import tn.cni.injez.model.FinancementEtranger;

public interface FinancementEtrangerService {
	List<FinancementEtranger> afficherFinancementsEtrangers();
	List<FinancementEtranger> findFinancementsEtrangersByProject();
	FinancementEtranger findFinancementEtrangerById(String code);
	FinancementEtranger ajouterFinancementEtranger(FinancementEtranger financement);
	FinancementEtranger modifierFinancementEtranger(FinancementEtranger financement);
	void supprimerFinancementEtranger(String code);
	List<FinancementEtranger> searchFinancementEtranger(String recherche2);

}
