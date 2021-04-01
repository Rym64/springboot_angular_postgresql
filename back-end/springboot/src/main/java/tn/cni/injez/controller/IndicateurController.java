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
import tn.cni.injez.model.Indicateur;
import tn.cni.injez.model.Objectif;
import tn.cni.injez.response.Response;
import tn.cni.injez.repository.IndicateurRepository;
import tn.cni.injez.service.IndicateurService;
import tn.cni.injez.service.ObjectifService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class IndicateurController {
	@Autowired
	private IndicateurService indicateurService;
	@Autowired
	private IndicateurRepository indicateurRepository;
	@Autowired
	private ObjectifService objectifService;
	
	
	@GetMapping("/afficherIndicateurs")
	public ResponseEntity<Response> afficherIndicateurs() {
		
		return ResponseEntity.status(HttpStatus.OK).body(new Response(indicateurService.afficherIndicateurs(), new Date()));
	}
	
	@PostMapping("/ajouterIndicateur")
	public ResponseEntity<Indicateur> ajouterIndicateur(@RequestBody Indicateur indicateur) {
	
		String projetCode = null;
		List<Objectif> liste = objectifService.objectifCourant();
		Iterator iter = liste.iterator();
		Objectif objectif = (Objectif) iter.next();
		if (indicateur != null) {
			indicateur.setObjectif(objectif);
			ResponseEntity<Indicateur> responseCreate = ResponseEntity.status(HttpStatus.OK)
					.body(indicateurService.ajouterIndicateur(indicateur));
			return responseCreate;
		} else {
			throw new ResourceNotFoundException("Can't create indicateur");
		}

	}
	
	@PostMapping("/modifierIndicateur")
	public Indicateur modifierIndicateur(@RequestBody Indicateur indicateur) {
		return indicateurService.modifierIndicateur(indicateur);
	}
	
	@DeleteMapping("/supprimerIndicateur")
	public HttpStatus supprimerIndicateur(@RequestParam("code") String code) {
		if (code != null) {
			indicateurService.supprimerIndicateur(code);
			HttpStatus responseDelete = HttpStatus.OK;
			return responseDelete;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}
	}

	

	@GetMapping("/rechercherIndicateur/{recherche}")
    public List<Indicateur> searchIndicateur (@PathVariable(value="recherche") String recherche){
    	return indicateurService.searchIndicateur(recherche);
    }
}
