package tn.cni.injez.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.injez.exception.ResourceNotFoundException;
import tn.cni.injez.model.Decomposition;
import tn.cni.injez.model.Projet;
import tn.cni.injez.repository.DecompositionRepository;
import java.sql.Date;
import java.util.Calendar;


@Service
public class DecompositionServiceImp implements DecompositionService {
	@Autowired
	private DecompositionRepository decompositionRepository;
	@Autowired
	private ProjetService projetService;
	
	
	@Override
	public List<Decomposition> afficherDecompositions() {
		List<Projet> liste = projetService.projetCourant();
		Iterator iter = liste.iterator();
		Projet projet = (Projet) iter.next();
		 return decompositionRepository.findAndOrder(projet.getCode());
	}

	
	
	 
	 
	@Override
	public Decomposition findDecompositionById(Integer id) {
		Decomposition financement=decompositionRepository.findById(id).get();
		 return financement;
		}
	@Override
	public Decomposition ajouterDecomposition(Decomposition decomposition) {
		
		Calendar c2 = Calendar.getInstance();
		Calendar c4 = Calendar.getInstance();

		if (decomposition != null) {
			
			if(decomposition.getDate_debut()!=null) {
			c2.setTime(decomposition.getDate_debut());
			c2.add(Calendar.DATE, 1);
			java.sql.Date dateDebut1= new java.sql.Date(c2.getTimeInMillis());
			decomposition.setDate_debut(dateDebut1);}
			
			
			if(decomposition.getDate_fin()!=null) {
			c4.setTime(decomposition.getDate_fin());
			c4.add(Calendar.DATE, 1);
			java.sql.Date dateFin1= new java.sql.Date(c4.getTimeInMillis());
			decomposition.setDate_fin(dateFin1);}
			
			
			
			
			return decompositionRepository.save(decomposition);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}
	
	@Override
	public Decomposition modifierDecomposition(Decomposition decomposition) {
		
		Calendar c3 = Calendar.getInstance();
		Calendar c5 = Calendar.getInstance();
		if (decomposition != null) {
			
		
			
		
			if(decomposition.getDate_debut_actualisee()!=null) {
			c3.setTime(decomposition.getDate_debut_actualisee());
			c3.add(Calendar.DATE, 1);
			java.sql.Date dateDebutActualise1= new java.sql.Date(c3.getTimeInMillis());
			decomposition.setDate_debut_actualisee(dateDebutActualise1);}
			
		
			if(decomposition.getDate_fin_actualisee()!=null) {
			c5.setTime(decomposition.getDate_fin_actualisee());
			c5.add(Calendar.DATE, 1);
			java.sql.Date dateFinActualise1= new java.sql.Date(c5.getTimeInMillis());
			decomposition.setDate_fin_actualisee(dateFinActualise1);}
			
			return decompositionRepository.save(decomposition);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}

	@Override
	public void supprimerDecomposition(Integer id) {
		if (id != null) {
			decompositionRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}

	}
	
	@Override
	public List<Decomposition> searchDecomposition(String recherche)
	{List<Decomposition> listDecompositions = this.afficherDecompositions();
	List<Decomposition> listDecompositions1 = new ArrayList<>();
	Set<Decomposition> setDecompositions = new LinkedHashSet<>();
	listDecompositions.forEach(decomposition -> {
		if ((decomposition.getDate_debut_actualisee())!=null) {if((decomposition.getDate_debut_actualisee()).toString().equals(recherche)) {setDecompositions.add(decomposition);}}
		if ((decomposition.getDate_fin_actualisee())!=null) {if((decomposition.getDate_fin_actualisee()).toString().equals(recherche)) {setDecompositions.add(decomposition);}}
		if ((decomposition.getCode())!=null) {if((decomposition.getCode()).equals(recherche)) {setDecompositions.add(decomposition);}}
		if ((decomposition.getLibelle())!=null) {if((decomposition.getLibelle()).equals(recherche)) {setDecompositions.add(decomposition);}}
		if ((decomposition.getMontant())!=null) {if((decomposition.getMontant()).toString().equals(recherche)) {setDecompositions.add(decomposition);}}
		if ((decomposition.getDate_debut())!=null) {if((decomposition.getDate_debut()).toString().equals(recherche)) {setDecompositions.add(decomposition);}}
		if ((decomposition.getDate_fin())!=null) {if((decomposition.getDate_fin()).toString().equals(recherche)) {setDecompositions.add(decomposition);}}
		if ((decomposition.getType_decomposition())!=null) {if((decomposition.getType_decomposition()).toString().equals(recherche)) {setDecompositions.add(decomposition);}}
		if ((decomposition.getNiveau_decomposition())!=null) {if((decomposition.getNiveau_decomposition()).toString().equals(recherche)) {setDecompositions.add(decomposition);}}

	}); 
	setDecompositions.forEach(decomposition2 -> {listDecompositions1.add(decomposition2);});
	return listDecompositions1;}
	
}
