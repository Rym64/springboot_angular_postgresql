package tn.cni.injez.controller;


import java.util.Iterator;
import java.util.List;
import java.util.Date;
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
import tn.cni.injez.model.AutreFinancement;
import tn.cni.injez.service.AutreFinancementService;
import tn.cni.injez.model.Projet;
import tn.cni.injez.response.Response;
import tn.cni.injez.service.ProjetService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AutreFinancementController {
	@Autowired
	private AutreFinancementService financementService;
	@Autowired
	private ProjetService projetService;
	
	
	@GetMapping("/afficherAutresFinancements")
	public ResponseEntity<Response> afficherAutresFinancements() {
		return ResponseEntity.status(HttpStatus.OK).body(new Response(financementService.afficherAutresFinancements(), new Date()));
	}
	
	@PostMapping("/ajouterAutreFinancement")
	public ResponseEntity<AutreFinancement> ajouterAutreFinancement(@RequestBody AutreFinancement financement) {
		String projetCode = null;
		List<Projet> liste = projetService.projetCourant();
		Iterator iter = liste.iterator();
		Projet projet = (Projet) iter.next();
		if (financement != null) {
			financement.setProjet(projet);
			ResponseEntity<AutreFinancement> responseCreate = ResponseEntity.status(HttpStatus.OK)
					.body(financementService.ajouterAutreFinancement(financement));
			return responseCreate;
		} else {
			throw new ResourceNotFoundException("Can't create financement");
		}

	}
	
	@PostMapping("/modifierAutreFinancement")
	public AutreFinancement modifierAutreFinancement(@RequestBody AutreFinancement financement) {
		return financementService.modifierAutreFinancement(financement);
	}
	
	@DeleteMapping("/supprimerAutreFinancement")
	public HttpStatus supprimerAutreFinancement(@RequestParam("code") String code) {
		if (code != null) {
			financementService.supprimerAutreFinancement(code);
			HttpStatus responseDelete = HttpStatus.OK;
			return responseDelete;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}
	}
	
	@GetMapping("/rechercherAutreFinancement/{recherche3}")
    public List<AutreFinancement> searchAutreFinancement (@PathVariable(value="recherche3") String recherche3){
    	return financementService.searchAutreFinancement(recherche3);
    }

}
