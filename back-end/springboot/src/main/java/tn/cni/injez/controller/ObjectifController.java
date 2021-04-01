package tn.cni.injez.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
import tn.cni.injez.model.Objectif;
import tn.cni.injez.model.Projet;
import tn.cni.injez.response.Response;
import tn.cni.injez.repository.ObjectifRepository;
import tn.cni.injez.service.ObjectifService;
import tn.cni.injez.service.ProjetService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ObjectifController {
	@Autowired
	private ObjectifService objectifService;
	@Autowired
	private ObjectifRepository objectifRepository;
	@Autowired
	private ProjetService projetService;
	
	
	@GetMapping("/afficherObjectifs")
	public ResponseEntity<Response> afficherObjectifs() {
		
		return ResponseEntity.status(HttpStatus.OK).body(new Response(objectifService.afficherObjectifs(), new Date()));
	}
	
	@PostMapping("/ajouterObjectif")
	public ResponseEntity<Objectif> ajouterObjectif(@RequestBody Objectif objectif) {
	
		String projetCode = null;
		List<Projet> liste = projetService.projetCourant();
		Iterator iter = liste.iterator();
		Projet projet = (Projet) iter.next();
		if (objectif != null) {
			objectif.setProjet(projet);
			ResponseEntity<Objectif> responseCreate = ResponseEntity.status(HttpStatus.OK)
					.body(objectifService.ajouterObjectif(objectif));
			return responseCreate;
		} else {
			throw new ResourceNotFoundException("Can't create objectif");
		}

	}
	
	@PostMapping("/modifierObjectif")
	public Objectif modifierObjectif(@RequestBody Objectif objectif) {
		return objectifService.modifierObjectif(objectif);
	}
	
	@DeleteMapping("/supprimerObjectif")
	public HttpStatus supprimerObjectif(@RequestParam("code") String code) {
		if (code != null) {
			objectifService.supprimerObjectif(code);
			HttpStatus responseDelete = HttpStatus.OK;
			return responseDelete;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}
	}

	

	@GetMapping("/rechercherObjectif/{recherche}")
    public List<Objectif> searchObjectif (@PathVariable(value="recherche") String recherche){
    	return objectifService.searchObjectif(recherche);
    }
}
