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
import tn.cni.injez.model.AppelOffre;
import tn.cni.injez.model.Projet;
import tn.cni.injez.response.Response;
import tn.cni.injez.repository.AppelOffreRepository;
import tn.cni.injez.service.AppelOffreService;
import tn.cni.injez.service.ProjetService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AppelOffreController {
	@Autowired
	private AppelOffreService appelOffreService;
	@Autowired
	private AppelOffreRepository appelOffreRepository;
	@Autowired
	private ProjetService projetService;
	
	
	@GetMapping("/afficherAppelsOffre")
	public ResponseEntity<Response> afficherAppelsOffre() {
		
		return ResponseEntity.status(HttpStatus.OK).body(new Response(appelOffreService.afficherAppelsOffre(), new Date()));
	}
	
	@PostMapping("/ajouterAppelOffre")
	public ResponseEntity<AppelOffre> ajouterAppelOffre(@RequestBody AppelOffre appelOffre) {
	
		String projetCode = null;
		List<Projet> liste = projetService.projetCourant();
		Iterator iter = liste.iterator();
		Projet projet = (Projet) iter.next();
		if (appelOffre != null) {
			appelOffre.setProjet(projet);
			ResponseEntity<AppelOffre> responseCreate = ResponseEntity.status(HttpStatus.OK)
					.body(appelOffreService.ajouterAppelOffre(appelOffre));
			return responseCreate;
		} else {
			throw new ResourceNotFoundException("Can't create appelOffre");
		}

	}
	
	@PostMapping("/modifierAppelOffre")
	public AppelOffre modifierAppelOffre(@RequestBody AppelOffre appelOffre) {
		return appelOffreService.modifierAppelOffre(appelOffre);
	}
	
	@DeleteMapping("/supprimerAppelOffre")
	public HttpStatus supprimerAppelOffre(@RequestParam("code") String code) {
		if (code != null) {
			appelOffreService.supprimerAppelOffre(code);
			HttpStatus responseDelete = HttpStatus.OK;
			return responseDelete;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}
	}

	@PostMapping("/selectAppelOffre")
	public AppelOffre selectAppelOffre(@RequestBody AppelOffre appelOffre) {
		appelOffreRepository.updateAll();
		appelOffre.setCurrent(1);
    return appelOffreService.modifierAppelOffre(appelOffre);
	}

	@GetMapping("/rechercherAppelOffre/{recherche}")
    public List<AppelOffre> searchAppelOffre (@PathVariable(value="recherche") String recherche){
    	return appelOffreService.searchAppelOffre(recherche);
    }
}
