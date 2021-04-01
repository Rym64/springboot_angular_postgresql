package tn.cni.injez.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.injez.exception.ResourceNotFoundException;
import tn.cni.injez.model.AutreFinancement;
import tn.cni.injez.model.Projet;
import tn.cni.injez.repository.AutreFinancementRepository;

@Service
public class AutreFinancementServiceImp implements AutreFinancementService {
	@Autowired
	private AutreFinancementRepository autreFinancementRepository;
	@Autowired
	private ProjetService projetService;
	
	@Override
	public List<AutreFinancement> afficherAutresFinancements() {
		return this.findAutresFinancementsByProject();
	}

	@Override
	public List<AutreFinancement> findAutresFinancementsByProject() {
		List<Projet> liste = projetService.projetCourant();
		Iterator iter = liste.iterator();
		Projet projet = (Projet) iter.next();
		List<AutreFinancement> listFinancements = autreFinancementRepository.findAll();
		List<AutreFinancement> listFinancements1 = new ArrayList<>();
		listFinancements.forEach(financement -> {
			if ((financement.getProjet())==projet) {
				listFinancements1.add(financement);
			}	
		}); 
		return listFinancements1;
		}
	@Override
	public AutreFinancement findAutreFinancementById(String code) {
		 AutreFinancement financement=autreFinancementRepository.findById(code).get();
		 return financement;
		}
	@Override
	public AutreFinancement ajouterAutreFinancement(AutreFinancement financement) {
		Calendar c1 = Calendar.getInstance();
		if (financement != null) {
			
			if(financement.getDate_autre_financement()!=null) {
				c1.setTime(financement.getDate_autre_financement());
				c1.add(Calendar.DATE, 1);
				java.sql.Date dateAutreFinancement1= new java.sql.Date(c1.getTimeInMillis());
				
				financement.setDate_autre_financement(dateAutreFinancement1);}
			
			return autreFinancementRepository.save(financement);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}
	
	@Override
	public AutreFinancement modifierAutreFinancement(AutreFinancement financement) {
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();

		if (financement != null) {
			if(financement.getDate_actualisation()!=null) {
			c.setTime(financement.getDate_actualisation());
			c.add(Calendar.DATE, 1);
			java.sql.Date dateActualisation1= new java.sql.Date(c.getTimeInMillis());
			
			financement.setDate_actualisation(dateActualisation1);}
			
			if(financement.getDate_autre_financement()!=null) {
				c1.setTime(financement.getDate_autre_financement());
				c1.add(Calendar.DATE, 1);
				java.sql.Date dateAutreFinancement1= new java.sql.Date(c1.getTimeInMillis());
				
				financement.setDate_autre_financement(dateAutreFinancement1);}
			
			return autreFinancementRepository.save(financement);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}

	@Override
	public void supprimerAutreFinancement(String code) {
		if (code != null) {
			autreFinancementRepository.deleteById(code);
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}

	}

	
	@Override
	public List<AutreFinancement> searchAutreFinancement(String recherche3)
	{List<AutreFinancement> listAutresFinancement = this.findAutresFinancementsByProject();
	List<AutreFinancement> listAutresFinancement1 = new ArrayList<>();
	Set<AutreFinancement> setAutresFinancements = new LinkedHashSet<>();
    listAutresFinancement.forEach(autrefinancement -> {
    	if ((autrefinancement.getMontant_actualise())!=null) {if ((autrefinancement.getMontant_actualise()).toString().equals(recherche3)) {setAutresFinancements.add(autrefinancement);} }
    	if ((autrefinancement.getDate_actualisation())!=null) {if ((autrefinancement.getDate_actualisation()).toString().equals(recherche3)) {setAutresFinancements.add(autrefinancement);} }
    	if ((autrefinancement.getCode())!=null) {if ((autrefinancement.getCode()).equals(recherche3)) {setAutresFinancements.add(autrefinancement);} }
    	if ((autrefinancement.getLibelle())!=null) {if ((autrefinancement.getLibelle()).equals(recherche3)) {setAutresFinancements.add(autrefinancement);} }
    	if ((autrefinancement.getDate_autre_financement())!=null) {if ((autrefinancement.getDate_autre_financement()).toString().equals(recherche3)) {setAutresFinancements.add(autrefinancement);} }
    	if ((autrefinancement.getMontant())!=null) {if ((autrefinancement.getMontant()).toString().equals(recherche3)) {setAutresFinancements.add(autrefinancement);} }
      } ); 
    setAutresFinancements.forEach(autreFinancement9 -> {listAutresFinancement1.add(autreFinancement9);});
	return listAutresFinancement1;}

}
