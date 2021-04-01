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
import tn.cni.injez.model.Marche;

import tn.cni.injez.response.Response;
import tn.cni.injez.repository.MarcheRepository;
import tn.cni.injez.model.LotAppelOffre;
import tn.cni.injez.service.MarcheService;
import tn.cni.injez.service.LotAppelOffreService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MarcheController {
	@Autowired
	private MarcheService marcheService;
	@Autowired
	private MarcheRepository marcheRepository;
	@Autowired
	private LotAppelOffreService lotAppelOffreService;
	
	
	@GetMapping("/afficherMarches")
	public ResponseEntity<Response> afficherMarches() {
		return ResponseEntity.status(HttpStatus.OK).body(new Response(marcheService.afficherMarches(), new Date()));
	}
	
	@PostMapping("/ajouterMarche")
	public ResponseEntity<Marche> ajouterMarche(@RequestBody Marche marche) {
		String lotAppelOffreCode = null;
		List<LotAppelOffre> liste = lotAppelOffreService.lotAppelOffreCourant();
		Iterator iter = liste.iterator();
		LotAppelOffre lotAppelOffre = (LotAppelOffre) iter.next();
		if (marche != null) {
			marche.setLot_appel_offre(lotAppelOffre);
			ResponseEntity<Marche> responseCreate = ResponseEntity.status(HttpStatus.OK)
					.body(marcheService.ajouterMarche(marche));
			return responseCreate;
		} else {
			throw new ResourceNotFoundException("Can't create marche");
		}
	}
	
	@PostMapping("/modifierMarche")
	public Marche modifierMarche(@RequestBody Marche marche) {
		return marcheService.modifierMarche(marche);
	}
	
	@DeleteMapping("/supprimerMarche")
	public HttpStatus supprimerMarche(@RequestParam("code") String code) {
		if (code != null) {
			marcheService.supprimerMarche(code);
			HttpStatus responseDelete = HttpStatus.OK;
			return responseDelete;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}
	}
	

	@PostMapping("/selectMarche")
	public Marche selectMarche(@RequestBody Marche marche) {
		marcheRepository.updateAll();
		marche.setCurrent(1);
    return marcheService.modifierMarche(marche);
	}
	
	@GetMapping("/rechercherMarche/{recherche}")
    public List<Marche> searchMarche (@PathVariable(value="recherche") String recherche){
    	return marcheService.searchMarche(recherche);
    }


}
