package tn.cni.injez.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.injez.exception.ResourceNotFoundException;
import tn.cni.injez.model.Facture;
import tn.cni.injez.model.Indicateur;
import tn.cni.injez.model.Objectif;
import tn.cni.injez.model.Projet;
import tn.cni.injez.repository.IndicateurRepository;


@Service
public class IndicateurServiceImp implements IndicateurService{
	
	@Autowired
	private IndicateurRepository indicateurRepository;
	
	@Autowired
	private ObjectifService objectifService;
	
	@Override
	public List<Indicateur> afficherIndicateurs() {
		return this.findIndicateursByObjectif();
	}

	@Override
	public List<Indicateur> findIndicateursByObjectif() {
		List<Objectif> liste = objectifService.objectifCourant();
		Iterator iter = liste.iterator();
		Objectif objectif = (Objectif) iter.next();
		List<Indicateur> listIndicateurs = indicateurRepository.findAll();
		List<Indicateur> listIndicateurs1 = new ArrayList<>();
		
		listIndicateurs.forEach(indicateur -> {
			if ((indicateur.getObjectif())==objectif) {
				listIndicateurs1.add(indicateur);
			}	
		}); 
		
		return listIndicateurs1;
		}
	@Override
	public Indicateur ajouterIndicateur(Indicateur indicateur) {
		if (indicateur != null) {
			return indicateurRepository.save(indicateur);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}
	
	@Override
	public Indicateur modifierIndicateur(Indicateur indicateur) {
		if (indicateur != null) {
			return indicateurRepository.save(indicateur);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}

	@Override
	public void supprimerIndicateur(String code) {
		if (code != null) {
			indicateurRepository.deleteById(code);
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}

	}
	
	
	@Override
	public List<Indicateur> searchIndicateur(String recherche)
	{List<Indicateur> listIndicateurs = this.findIndicateursByObjectif();
	List<Indicateur> listIndicateurs1 = new ArrayList<>();
	Set<Indicateur> setIndicateurs = new LinkedHashSet<>();
	listIndicateurs.forEach(indicateur -> {
    	if ((indicateur.getCode())!=null) {if ((indicateur.getCode()).equals(recherche)) {setIndicateurs.add(indicateur);} }
    	if ((indicateur.getLibelle())!=null) {if ((indicateur.getLibelle()).equals(recherche)) {setIndicateurs.add(indicateur);} }
    	if ((indicateur.getDescription())!=null) {if ((indicateur.getDescription()).equals(recherche)) {setIndicateurs.add(indicateur);} }

	}); 
	setIndicateurs.forEach(indicateur9 -> {listIndicateurs1.add(indicateur9);});

	return listIndicateurs1;}

}
