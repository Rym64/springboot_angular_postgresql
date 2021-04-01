package tn.cni.injez.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import java.util.logging.Logger;
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
import tn.cni.injez.model.Projet;
import tn.cni.injez.response.Response;
import tn.cni.injez.model.Etablissement;
import tn.cni.injez.model.Utilisateur;
import tn.cni.injez.repository.ProjetRepository;
import tn.cni.injez.service.ProjetService;
import tn.cni.injez.service.UtilisateurService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProjetController {
	Set<Utilisateur> users = new HashSet<>();

	Logger logger = Logger.getLogger(ProjetController.class.getName());

	@Autowired
	private ProjetService projetService;
	
	@Autowired
	private ProjetRepository projetRepository;
	
	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping("/afficherProjets")
	public ResponseEntity<Response> afficherProjets() {
		return ResponseEntity.status(HttpStatus.OK).body(new Response(projetService.afficherProjets(), new Date()));
	}

	
	@PostMapping("/ajouterProjet")
	public ResponseEntity<Projet> ajouterProjet(@RequestBody Projet projet) {
		
		List<Utilisateur> liste = utilisateurService.utilisateurCourant();
		Iterator iter = liste.iterator();
		Utilisateur utilisateur = (Utilisateur) iter.next();
		if (projet != null) {
			projet.setEtablissement(utilisateur.getEtablissement());
			ResponseEntity<Projet> responseCreate = ResponseEntity.status(HttpStatus.OK)
					.body(projetService.ajouterProjet(projet));
			return responseCreate;
		} else {
			throw new ResourceNotFoundException("Can't create project");
		}

	}

	@PostMapping("/modifierProjet")
	public Projet modifierProjet(@RequestBody Projet projetDetails) {
		return projetService.modifierProjet(projetDetails);
	}

	@DeleteMapping("/supprimerProjet")
	public HttpStatus supprimerProjet(@RequestParam("code") String code) {
		if (code != null) {
			projetService.supprimerProjet(code);
			HttpStatus responseDelete = HttpStatus.OK;
			logger.info("Deleted successfully");
			return responseDelete;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}
	}
	
	
	@PostMapping("/selectProjet")
	public Projet selectProjet(@RequestBody Projet projet) {
		projetRepository.updateAll();
		projet.setCurrent(1);
      return projetService.modifierProjet(projet);
    
	}
	
	@GetMapping("/projetCurrent")
	public List<Projet> projetCurrent() {
		List<Projet> listeProjets=projetRepository.findAll();
		List<Projet> listeProjets1=new ArrayList<>();
		listeProjets.forEach(projet -> {if (projet.getCurrent()==1)
			listeProjets1.add(projet);
		});
		
		return listeProjets1;
    
	}
	
	@GetMapping("/rechercherProjet/{recherche}")
    public List<Projet> searchProjet (@PathVariable(value="recherche") String recherche){
		
    	return projetService.searchProjet(recherche);
    }
	
	
	@GetMapping("/supprimerFinancementPublic")
	public void supprimerFinancementPublic() {
		List<Projet> liste = this.projetCurrent();
		Iterator iter = liste.iterator();
		Projet projetCurrent = (Projet) iter.next();
		projetRepository.deleteFinancementPublic(projetCurrent.getCode());
	
	}


	

}
