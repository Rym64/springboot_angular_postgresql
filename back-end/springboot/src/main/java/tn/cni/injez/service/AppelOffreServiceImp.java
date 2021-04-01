package tn.cni.injez.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.injez.exception.ResourceNotFoundException;
import tn.cni.injez.model.AppelOffre;
import tn.cni.injez.model.Projet;
import tn.cni.injez.repository.AppelOffreRepository;
import java.sql.Date;
import java.util.Calendar;

@Service
public class AppelOffreServiceImp implements AppelOffreService{
	@Autowired
	private AppelOffreRepository appelOffreRepository;
	@Autowired
	private ProjetService projetService;

	@Override
	public List<AppelOffre> afficherAppelsOffre() {
		return this.findAppelsOffreByProject();
	}

	@Override
	public List<AppelOffre> findAppelsOffreByProject() {
		List<Projet> liste = projetService.projetCourant();
		Iterator iter = liste.iterator();
		Projet projet = (Projet) iter.next();
		List<AppelOffre> listAppelsOffre = appelOffreRepository.findAll();
		List<AppelOffre> listAppelsOffre1 = new ArrayList<>();
		
		listAppelsOffre.forEach(appelOffre -> {
			if ((appelOffre.getProjet())==projet) {
				listAppelsOffre1.add(appelOffre);
			}	
		} ); 
		
		return listAppelsOffre1;
		}
	
	@Override
	public AppelOffre findById(String code) {
		 AppelOffre appelOffre=appelOffreRepository.findById(code).get();
		 return appelOffre;
		}
	
	@Override
	public AppelOffre ajouterAppelOffre(AppelOffre appelOffre) {
		Calendar c1 = Calendar.getInstance();
		
		if (appelOffre != null) {
			
			if(appelOffre.getDate_appel_offre()!=null) {
	            c1.setTime(appelOffre.getDate_appel_offre());
				
				c1.add(Calendar.DATE, 1);
				java.sql.Date dateAppelOffre1= new java.sql.Date(c1.getTimeInMillis());
				appelOffre.setDate_appel_offre(dateAppelOffre1);}
			
			return appelOffreRepository.save(appelOffre);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}
	
	@Override
	public AppelOffre modifierAppelOffre(AppelOffre appelOffre) {
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		if (appelOffre != null) {
			
			if(appelOffre.getDate_actualisation()!=null) {
            c.setTime(appelOffre.getDate_actualisation());
			
			c.add(Calendar.DATE, 1);
			java.sql.Date dateActualisation1= new java.sql.Date(c.getTimeInMillis());
			appelOffre.setDate_actualisation(dateActualisation1);}
			
			if(appelOffre.getDate_appel_offre()!=null) {
	            c1.setTime(appelOffre.getDate_appel_offre());
				
				c1.add(Calendar.DATE, 1);
				java.sql.Date dateAppelOffre1= new java.sql.Date(c1.getTimeInMillis());
				appelOffre.setDate_appel_offre(dateAppelOffre1);}
			
			return appelOffreRepository.save(appelOffre);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}

	@Override
	public void supprimerAppelOffre(String code) {
		if (code != null) {
			appelOffreRepository.deleteById(code);
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}

	}
	
	@Override
	public List<AppelOffre> appelOffreCourant() {
		List<AppelOffre> listAppelOffres = appelOffreRepository.findAll();
		List<AppelOffre> listAppelOffres1 = new ArrayList<>();
		listAppelOffres.forEach(appelOffre -> {
			if ((appelOffre.getCurrent()) == 1)
				listAppelOffres1.add(appelOffre);
		}); 
		return listAppelOffres1;
	}
	
	@Override
	public List<AppelOffre> searchAppelOffre(String recherche)
	{List<AppelOffre> listAppelsOffre = this.findAppelsOffreByProject();
	List<AppelOffre> listAppelsOffre1 = new ArrayList<>();
	Set<AppelOffre> setAppelsOffre = new LinkedHashSet<>();
	listAppelsOffre.forEach(appelOffre -> {
		if ((appelOffre.getMontant_actualise())!=null) {if((appelOffre.getMontant_actualise()).toString().equals(recherche)) {setAppelsOffre.add(appelOffre);}}
		if ((appelOffre.getDate_actualisation())!=null) {if((appelOffre.getDate_actualisation()).toString().equals(recherche)) {setAppelsOffre.add(appelOffre);}}
		if ((appelOffre.getCode())!=null){if ((appelOffre.getCode()).equals(recherche)){setAppelsOffre.add(appelOffre);}}
		if ((appelOffre.getLibelle())!=null){if ((appelOffre.getLibelle()).equals(recherche)){setAppelsOffre.add(appelOffre);}}
	    if ((appelOffre.getMontant_estime())!=null){if((appelOffre.getMontant_estime()).toString().equals(recherche)){setAppelsOffre.add(appelOffre);}}
	    if ((appelOffre.getDate_appel_offre())!=null){if ((appelOffre.getDate_appel_offre()).toString().equals(recherche)){setAppelsOffre.add(appelOffre);}}
	    if ((appelOffre.getEtat())!=null) {if ((appelOffre.getEtat()).toString().equals(recherche)){setAppelsOffre.add(appelOffre);}}			
	    });
	setAppelsOffre.forEach(appelOffre2 -> {listAppelsOffre1.add(appelOffre2);});
	return listAppelsOffre1;}
	
}
