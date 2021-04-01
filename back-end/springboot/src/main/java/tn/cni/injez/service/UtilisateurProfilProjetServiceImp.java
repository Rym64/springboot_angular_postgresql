package tn.cni.injez.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.injez.exception.ResourceNotFoundException;
import tn.cni.injez.model.Marche;
import tn.cni.injez.model.Utilisateur;
import tn.cni.injez.model.UtilisateurProfilProjet;
import tn.cni.injez.repository.UtilisateurProfilProjetRepository;
import java.sql.Date;
import java.util.Calendar;

@Service
public class UtilisateurProfilProjetServiceImp implements UtilisateurProfilProjetService{
	@Autowired
	private UtilisateurProfilProjetRepository utilisateurProfilProjetRepository;
	@Autowired
	private UtilisateurService utilisateurService;

	@Override
	public List<UtilisateurProfilProjet> afficherUtilisateursProfilsProjets() {
		return this.findUtilisateursProfilsProjets();
	}

	@Override
	public List<UtilisateurProfilProjet> findUtilisateursProfilsProjets() {
		List<Utilisateur> liste = utilisateurService.utilisateurCourant();
		
		Iterator iter = liste.iterator();
		Utilisateur user = (Utilisateur) iter.next();
		
		List<UtilisateurProfilProjet> listUtilisateursProfilsProjets = utilisateurProfilProjetRepository.findAll();
		
		List<UtilisateurProfilProjet> listUtilisateursProfilsProjets1 = new ArrayList<>();
		
		listUtilisateursProfilsProjets.forEach(utilisateurProfilProjet -> {
			
			if ((utilisateurProfilProjet.getUser().getEtablissement())==user.getEtablissement()) {
				
				listUtilisateursProfilsProjets1.add(utilisateurProfilProjet);
			}	
		}); 
		
		return listUtilisateursProfilsProjets1;
		}
	
	@Override
	public UtilisateurProfilProjet findById(Integer id) {
		UtilisateurProfilProjet utilisateurProfilProjet=utilisateurProfilProjetRepository.findById(id).get();
		 return utilisateurProfilProjet;
		}
	
	@Override
	public UtilisateurProfilProjet ajouterUtilisateurProfilProjet(UtilisateurProfilProjet utilisateurProfilProjet) {
		if (utilisateurProfilProjet != null) {
			return utilisateurProfilProjetRepository.save(utilisateurProfilProjet);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}
	
	@Override
	public UtilisateurProfilProjet modifierUtilisateurProfilProjet(UtilisateurProfilProjet utilisateurProfilProjet) {
		
		if (utilisateurProfilProjet != null) {
			return utilisateurProfilProjetRepository.save(utilisateurProfilProjet);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}

	@Override
	public void supprimerUtilisateurProfilProjet(Integer id) {
		if (id != null) {
			utilisateurProfilProjetRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}

	}
	
	
	
	@Override
	public List<UtilisateurProfilProjet> searchUtilisateurProfilProjet(String recherche)
	{List<UtilisateurProfilProjet> listUtilisateursProfilsProjets = this.findUtilisateursProfilsProjets();
	List<UtilisateurProfilProjet> listUtilisateursProfilsProjets1 = new ArrayList<>();
	Set<UtilisateurProfilProjet> setUtilisateurProfilProjet = new LinkedHashSet<>();
	listUtilisateursProfilsProjets.forEach(utilisateurProfilProjet -> {
		if ((utilisateurProfilProjet.getProfil())!=null) {if ((utilisateurProfilProjet.getProfil().getId()).equals(recherche)) {setUtilisateurProfilProjet.add(utilisateurProfilProjet);} }
		if ((utilisateurProfilProjet.getProjet())!=null) {if ((utilisateurProfilProjet.getProjet().getCode()).equals(recherche)) {setUtilisateurProfilProjet.add(utilisateurProfilProjet);} }
		if ((utilisateurProfilProjet.getUser().getUsername()).equals(recherche)) {listUtilisateursProfilsProjets1.add(utilisateurProfilProjet);}
	}); 
	
		setUtilisateurProfilProjet.forEach(utilisateurProfilProjet2 -> {
			listUtilisateursProfilsProjets1.add(utilisateurProfilProjet2);	
		});
	return listUtilisateursProfilsProjets1;}
	
}
