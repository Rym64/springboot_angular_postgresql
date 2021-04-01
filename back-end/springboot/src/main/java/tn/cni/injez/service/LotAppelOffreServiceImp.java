package tn.cni.injez.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.injez.exception.ResourceNotFoundException;
import tn.cni.injez.model.LotAppelOffre;
import tn.cni.injez.model.AppelOffre;
import tn.cni.injez.repository.LotAppelOffreRepository;
import java.sql.Date;
import java.util.Calendar;

@Service
public class LotAppelOffreServiceImp implements LotAppelOffreService{
	@Autowired
	private LotAppelOffreRepository lotAppelOffreRepository;
	@Autowired
	private AppelOffreService appelOffreService;

	@Override
	public List<LotAppelOffre> afficherLotsAppelOffre() {
		return this.findLotsAppelOffreByAppelOffre();
	}

	@Override
	public List<LotAppelOffre> findLotsAppelOffreByAppelOffre() {
		List<AppelOffre> liste = appelOffreService.appelOffreCourant();
		
		Iterator iter = liste.iterator();
		AppelOffre appelOffre = (AppelOffre) iter.next();
		
		List<LotAppelOffre> listLotsAppelOffre = lotAppelOffreRepository.findAll();
		
		List<LotAppelOffre> listLotsAppelOffre1 = new ArrayList<>();
		
		listLotsAppelOffre.forEach(lotAppelOffre -> {
			
			if ((lotAppelOffre.getAppel_offre())==appelOffre) {
				
				listLotsAppelOffre1.add(lotAppelOffre);
			}	
		}); 
		
		return listLotsAppelOffre1;
		}
	
	@Override
	public LotAppelOffre findById(String code) {
		 LotAppelOffre lotAppelOffre=lotAppelOffreRepository.findById(code).get();
		 return lotAppelOffre;
		}
	
	@Override
	public LotAppelOffre ajouterLotAppelOffre(LotAppelOffre lotAppelOffre) {
		Calendar c1 = Calendar.getInstance();
		if (lotAppelOffre != null) {
			
			if(lotAppelOffre.getDate_lot()!=null) {
	            c1.setTime(lotAppelOffre.getDate_lot());
				
				c1.add(Calendar.DATE, 1);
				java.sql.Date dateLotAppelOffre1= new java.sql.Date(c1.getTimeInMillis());
				lotAppelOffre.setDate_lot(dateLotAppelOffre1);}
			
			return lotAppelOffreRepository.save(lotAppelOffre);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}
	
	@Override
	public LotAppelOffre modifierLotAppelOffre(LotAppelOffre lotAppelOffre) {
		
		Calendar c1 = Calendar.getInstance();
		
		if (lotAppelOffre != null) {
			if(lotAppelOffre.getDate_lot()!=null) {
	            c1.setTime(lotAppelOffre.getDate_lot());
				
				c1.add(Calendar.DATE, 1);
				java.sql.Date dateLotAppelOffre1= new java.sql.Date(c1.getTimeInMillis());
				lotAppelOffre.setDate_lot(dateLotAppelOffre1);}
			
			return lotAppelOffreRepository.save(lotAppelOffre);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}

	@Override
	public void supprimerLotAppelOffre(String code) {
		if (code != null) {
			lotAppelOffreRepository.deleteById(code);
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}

	}
	
	@Override
	public List<LotAppelOffre> lotAppelOffreCourant() {
		List<LotAppelOffre> listLotsAppelOffre = lotAppelOffreRepository.findAll();
		List<LotAppelOffre> listLotsAppelOffre1 = new ArrayList<>();
		listLotsAppelOffre.forEach(lotAppelOffre -> {
			if ((lotAppelOffre.getCurrent()) == 1)
				listLotsAppelOffre1.add(lotAppelOffre);
		}); 
		return listLotsAppelOffre1;
	}
	
	@Override
	public List<LotAppelOffre> searchLotAppelOffre(String recherche)
	{List<LotAppelOffre> listLotsAppelOffre = this.findLotsAppelOffreByAppelOffre();
	List<LotAppelOffre> listLotsAppelOffre1 = new ArrayList<>();
	Set<LotAppelOffre> setLotsAppelOffre = new LinkedHashSet<>();

	listLotsAppelOffre.forEach(lotAppelOffre -> {
    	if ((lotAppelOffre.getMontant())!=null) {if ((lotAppelOffre.getMontant()).toString().equals(recherche)) {setLotsAppelOffre.add(lotAppelOffre);} }
    	if ((lotAppelOffre.getCode())!=null) {if ((lotAppelOffre.getCode()).equals(recherche)) {setLotsAppelOffre.add(lotAppelOffre);} }
    	if ((lotAppelOffre.getDate_lot())!=null) {if ((lotAppelOffre.getDate_lot()).toString().equals(recherche)) {setLotsAppelOffre.add(lotAppelOffre);} }

	}); 
	setLotsAppelOffre.forEach(lot9 -> {listLotsAppelOffre1.add(lot9);});

	return listLotsAppelOffre1;}
	
}
