package tn.cni.injez.service;

import java.util.List;

import tn.cni.injez.model.AutreFinancement;

public interface AutreFinancementService {
	List<AutreFinancement> afficherAutresFinancements();
	List<AutreFinancement> findAutresFinancementsByProject();
	AutreFinancement findAutreFinancementById(String code);
	AutreFinancement ajouterAutreFinancement(AutreFinancement financement);
	AutreFinancement modifierAutreFinancement(AutreFinancement financement);
	void supprimerAutreFinancement(String code);
	List<AutreFinancement> searchAutreFinancement(String recherche3);

}
