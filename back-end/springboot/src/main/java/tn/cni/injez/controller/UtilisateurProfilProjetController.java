package tn.cni.injez.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.cni.injez.exception.ResourceNotFoundException;
import tn.cni.injez.model.UtilisateurProfilProjet;
import tn.cni.injez.repository.UtilisateurProfilProjetRepository;
import tn.cni.injez.response.Response;
import tn.cni.injez.model.Marche;
import tn.cni.injez.model.Projet;
import tn.cni.injez.model.Utilisateur;
import tn.cni.injez.service.UtilisateurProfilProjetService;
import tn.cni.injez.service.UtilisateurService;
import tn.cni.injez.service.MarcheService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UtilisateurProfilProjetController {
	@Autowired
	private UtilisateurProfilProjetService utilisateurProfilProjetService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	UtilisateurProfilProjetRepository utilisateurProfilProjetRepository;

	
	
	@GetMapping("/afficherUtilisateursProfilsProjets")
	public ResponseEntity<Response> afficherUtilisateursProfilsProjets() {
		return ResponseEntity.status(HttpStatus.OK).body(new Response(utilisateurProfilProjetService.afficherUtilisateursProfilsProjets(), new Date()));
	}
	
	@PostMapping("/ajouterUtilisateurProfilProjet")
	public ResponseEntity<UtilisateurProfilProjet> ajouterUtilisateurProfilProjet(@RequestBody UtilisateurProfilProjet utilisateurProfilProjet) {
	
		if (utilisateurProfilProjet != null) {
			
			ResponseEntity<UtilisateurProfilProjet> responseCreate = ResponseEntity.status(HttpStatus.OK)
					.body(utilisateurProfilProjetService.ajouterUtilisateurProfilProjet(utilisateurProfilProjet));
			return responseCreate;
		} else {
			throw new ResourceNotFoundException("Can't create utilisateurProfilProjet");
		}

	}
	
	@PostMapping("/modifierUtilisateurProfilProjet")
	public UtilisateurProfilProjet modifierUtilisateurProfilProjet(@RequestBody UtilisateurProfilProjet utilisateurProfilProjet) {
		return utilisateurProfilProjetService.modifierUtilisateurProfilProjet(utilisateurProfilProjet);
	}
	
	@DeleteMapping("/supprimerUtilisateurProfilProjet")
	public HttpStatus supprimerUtilisateurProfilProjet(@RequestParam("id") Integer id) {
		if (id != null) {
			utilisateurProfilProjetService.supprimerUtilisateurProfilProjet(id);
			HttpStatus responseDelete = HttpStatus.OK;
			return responseDelete;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}
	}
	
	@GetMapping("/rechercherUtilisateurProfilProjet/{recherche}")
    public List<UtilisateurProfilProjet> searchMarche (@PathVariable(value="recherche") String recherche){
    	return utilisateurProfilProjetService.searchUtilisateurProfilProjet(recherche);
    }
	
	
	@GetMapping("/trouverUtilisateurs")
	public List<Utilisateur> trouverUtilisateurs(){
		List<Utilisateur> liste = utilisateurService.utilisateurCourant();
		Iterator iter = liste.iterator();
		Utilisateur user = (Utilisateur) iter.next();
		List<UtilisateurProfilProjet> listUsers = utilisateurProfilProjetRepository.findAll(); 
		List<Utilisateur> listUsers1 = new ArrayList<>();
		Set<Utilisateur> setUtilisateurs = new LinkedHashSet<>();
		listUsers.forEach(projetProfilUser -> {
			if ((projetProfilUser.getUser().getEtablissement())==user.getEtablissement()) {
				setUtilisateurs.add(projetProfilUser.getUser());
			}
			
		}); 
		setUtilisateurs.forEach(user2 -> {
			listUsers1.add(user2);	
		});
		
		return listUsers1;
		
		}
	
	
	
	
	@GetMapping("/trouverProjets")
	public List<Projet> trouverProjets(){
		List<Utilisateur> liste = utilisateurService.utilisateurCourant();
		Iterator iter = liste.iterator();
		Utilisateur user = (Utilisateur) iter.next();
		List<UtilisateurProfilProjet> listProjets = utilisateurProfilProjetRepository.findAll(); 
		List<Projet> listProjets1 = new ArrayList<>();
		Set<Projet> setProjets = new LinkedHashSet<>();
		listProjets.forEach(projetProfilUser -> {
			if ((projetProfilUser.getUser().getEtablissement())==user.getEtablissement()) {
				setProjets.add(projetProfilUser.getProjet());
			}
			
		}); 
		setProjets.forEach(projet2 -> {
			listProjets1.add(projet2);	
		});
		
		return listProjets1;
		
		}


}
