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
import tn.cni.injez.model.FinancementEtranger;
import tn.cni.injez.model.Projet;
import tn.cni.injez.response.Response;
import tn.cni.injez.service.FinancementEtrangerService;
import tn.cni.injez.service.ProjetService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FinancementEtrangerController {
	
	@Autowired
	private FinancementEtrangerService financementService;
	@Autowired
	private ProjetService projetService;
	
	@GetMapping("/afficherFinancementsEtrangers")
	public ResponseEntity<Response> afficherFinancementsEtrangers() {
		return ResponseEntity.status(HttpStatus.OK).body(new Response(financementService.afficherFinancementsEtrangers(), new Date()));
	}
	
	@PostMapping("/ajouterFinancementEtranger")
	public ResponseEntity<FinancementEtranger> ajouterFinancementEtranger(@RequestBody FinancementEtranger financement) {
		String projetCode = null;
		List<Projet> liste = projetService.projetCourant();
		Iterator iter = liste.iterator();
		Projet projet = (Projet) iter.next();
		if (financement != null) {
			financement.setProjet(projet);
			ResponseEntity<FinancementEtranger> responseCreate = ResponseEntity.status(HttpStatus.OK)
					.body(financementService.ajouterFinancementEtranger(financement));
			return responseCreate;
		} else {
			throw new ResourceNotFoundException("Can't create financement");
		}

	}
	
	@PostMapping("/modifierFinancementEtranger")
	public FinancementEtranger modifierFinancementEtranger(@RequestBody FinancementEtranger financement) {
		return financementService.modifierFinancementEtranger(financement);
	}
	
	@DeleteMapping("/supprimerFinancementEtranger")
	public HttpStatus supprimerFinancementEtranger(@RequestParam("code") String code) {
		if (code != null) {
			financementService.supprimerFinancementEtranger(code);
			HttpStatus responseDelete = HttpStatus.OK;
			return responseDelete;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}
	}
	
	@GetMapping("/rechercherFinancementEtranger/{recherche2}")
    public List<FinancementEtranger> searchFinancementEtranger (@PathVariable(value="recherche2") String recherche2){
    	return financementService.searchFinancementEtranger(recherche2);
    }
	

}
