package tn.cni.injez.service;

import java.util.List;

import tn.cni.injez.model.Decomposition;

public interface DecompositionService {
	List<Decomposition> afficherDecompositions();
	Decomposition findDecompositionById(Integer id);
	Decomposition ajouterDecomposition(Decomposition financement);
	Decomposition modifierDecomposition(Decomposition financement);
	void supprimerDecomposition(Integer id);
	List<Decomposition> searchDecomposition(String recherche);
}
