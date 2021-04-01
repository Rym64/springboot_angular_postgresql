package tn.cni.injez.service;

import java.util.List;

import tn.cni.injez.model.Facture;

public interface FactureService {
	List<Facture> afficherFactures();
	List<Facture> findFacturesByMarche();
	Facture findFactureById(String code);
	Facture ajouterFacture(Facture facture);
	Facture modifierFacture(Facture facture);
	void supprimerFacture(String code);
	List<Facture> searchFacture(String recherche);

}
