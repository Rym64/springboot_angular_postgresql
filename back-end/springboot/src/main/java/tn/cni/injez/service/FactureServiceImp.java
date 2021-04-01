package tn.cni.injez.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.injez.exception.ResourceNotFoundException;
import tn.cni.injez.model.AutreFinancement;
import tn.cni.injez.model.Facture;
import tn.cni.injez.model.Marche;
import tn.cni.injez.repository.FactureRepository;
import java.sql.Date;
import java.util.Calendar;

@Service
public class FactureServiceImp implements FactureService{
	@Autowired
	private FactureRepository factureRepository;
	@Autowired
	private MarcheService marcheService;
	
	
	@Override
	public List<Facture> afficherFactures() {
		return this.findFacturesByMarche();
		

	}

	@Override
	public List<Facture> findFacturesByMarche() {
		List<Marche> liste = marcheService.marcheCourant();
		Iterator iter = liste.iterator();
		Marche marche = (Marche) iter.next();
		List<Facture> listFactures = factureRepository.findAll();
		List<Facture> listFactures1 = new ArrayList<>();
	    listFactures.forEach(facture -> {
			if ((facture.getMarche())==marche) {
				listFactures1.add(facture);
			}	
		}); 
		return listFactures1;
		}
	@Override
	public Facture findFactureById(String code) {
		 Facture facture=factureRepository.findById(code).get();
		 return facture;
		}
	@Override
	public Facture ajouterFacture(Facture facture) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		if (facture != null) {
			
			if(facture.getDate_facture()!=null) {
				c1.setTime(facture.getDate_facture());
				c1.add(Calendar.DATE, 1);
				java.sql.Date dateFacture1= new java.sql.Date(c1.getTimeInMillis());
				facture.setDate_payement(dateFacture1);}
			
			if(facture.getDate_payement()!=null) {
			c2.setTime(facture.getDate_payement());
			c2.add(Calendar.DATE, 1);
			java.sql.Date datePayement1= new java.sql.Date(c2.getTimeInMillis());
			facture.setDate_payement(datePayement1);}
			
			return factureRepository.save(facture);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}
	
	@Override
	public Facture modifierFacture(Facture facture) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		if (facture != null) {
			
			if(facture.getDate_facture()!=null) {
				c1.setTime(facture.getDate_facture());
				c1.add(Calendar.DATE, 1);
				java.sql.Date dateFacture1= new java.sql.Date(c1.getTimeInMillis());
				facture.setDate_payement(dateFacture1);}
			
			if(facture.getDate_payement()!=null) {
			c2.setTime(facture.getDate_payement());
			c2.add(Calendar.DATE, 1);
			java.sql.Date datePayement1= new java.sql.Date(c2.getTimeInMillis());
			facture.setDate_payement(datePayement1);}
			
			return factureRepository.save(facture);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}

	@Override
	public void supprimerFacture(String code) {
		if (code != null) {
			factureRepository.deleteById(code);
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}

	}

	@Override
	public List<Facture> searchFacture(String recherche)
	{List<Facture> listFactures = this.findFacturesByMarche();
	List<Facture> listFactures1 = new ArrayList<>();
	Set<Facture> setFactures = new LinkedHashSet<>();
	listFactures.forEach(facture -> {
    	if ((facture.getMontant())!=null) {if ((facture.getMontant()).toString().equals(recherche)) {setFactures.add(facture);} }
    	if ((facture.getCode())!=null) {if ((facture.getCode()).equals(recherche)) {setFactures.add(facture);} }
    	if ((facture.getMontant_paye())!=null) {if ((facture.getMontant_paye()).toString().equals(recherche)) {setFactures.add(facture);} }
    	if ((facture.getDate_facture())!=null) {if ((facture.getDate_facture()).toString().equals(recherche)) {setFactures.add(facture);} }
    	if ((facture.getDate_payement())!=null) {if ((facture.getDate_payement()).toString().equals(recherche)) {setFactures.add(facture);} }

			}); 
	setFactures.forEach(facture9 -> {listFactures1.add(facture9);});

	return listFactures1;}
	
	


}
