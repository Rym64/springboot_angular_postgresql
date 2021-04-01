package tn.cni.injez.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.injez.exception.ResourceNotFoundException;
import tn.cni.injez.model.Objectif;

import tn.cni.injez.model.Projet;
import tn.cni.injez.repository.ObjectifRepository;



@Service
public class ObjectifServiceImp implements ObjectifService{
	
	@Autowired
	private ObjectifRepository objectifRepository;
	@Autowired
	private ProjetService projetService;
	
	@Override
	public List<Objectif> afficherObjectifs() {
		return this.findObjectifsByProject();
	}

	@Override
	public List<Objectif> findObjectifsByProject() {
		List<Projet> liste = projetService.projetCourant();
		Iterator iter = liste.iterator();
		Projet projet = (Projet) iter.next();
		
		List<Objectif> listObjectifs = objectifRepository.findAll();
		
		List<Objectif> listObjectifs1 = new ArrayList<>();
		
		listObjectifs.forEach(objectif -> {
			if ((objectif.getProjet())==projet) {
				listObjectifs1.add(objectif);
			}	
		}); 
		
		return listObjectifs1;
		}
	
	@Override
	public Objectif ajouterObjectif(Objectif objectif) {
		if (objectif != null) {
			return objectifRepository.save(objectif);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}
	
	@Override
	public Objectif modifierObjectif(Objectif objectif) {
		if (objectif != null) {
			return objectifRepository.save(objectif);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}

	@Override
	public void supprimerObjectif(String code) {
		if (code != null ) {
			objectifRepository.deleteById(code);
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}

	}
	
	
	@Override
	public List<Objectif> searchObjectif(String recherche)
	{List<Objectif> listObjectifs = this.findObjectifsByProject();
	List<Objectif> listObjectifs1 = new ArrayList<>();
	Set<Objectif> setObjectifs = new LinkedHashSet<>();
	listObjectifs.forEach(objectif -> {
    	if ((objectif.getCode())!=null) {if ((objectif.getCode()).equals(recherche)) {setObjectifs.add(objectif);} }
    	if ((objectif.getDescription())!=null) {if ((objectif.getDescription()).equals(recherche)) {setObjectifs.add(objectif);} }
    	if ((objectif.getType_objectif())!=null) {if ((objectif.getType_objectif()).toString().equals(recherche)) {setObjectifs.add(objectif);} }
    	if ((objectif.getLibelle())!=null) {if ((objectif.getLibelle()).equals(recherche)) {setObjectifs.add(objectif);} }

	}); 
	setObjectifs.forEach(objectif9 -> {listObjectifs1.add(objectif9);});

	return listObjectifs1;}
	
	@Override
	public List<Objectif> objectifCourant() {
		List<Objectif> listObjectifs = objectifRepository.findAll();
		List<Objectif> listObjectifs1 = new ArrayList<>();
		listObjectifs.forEach(objectif -> {
			if ((objectif.getCurrent()) == 1)
				listObjectifs1.add(objectif);
		}); 
		return listObjectifs1;
	}

}
