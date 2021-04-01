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
import tn.cni.injez.model.LotAppelOffre;
import tn.cni.injez.model.AppelOffre;
import tn.cni.injez.response.Response;
import tn.cni.injez.repository.LotAppelOffreRepository;
import tn.cni.injez.service.LotAppelOffreService;
import tn.cni.injez.service.AppelOffreService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LotAppelOffreController {
	@Autowired
	private LotAppelOffreService lotAppelOffreService;
	@Autowired
	private LotAppelOffreRepository lotAppelOffreRepository;
	@Autowired
	private AppelOffreService appelOffreService;
	
	
	@GetMapping("/afficherLotsAppelOffre")
	public ResponseEntity<Response> afficherLotsAppelOffre() {
		
		return ResponseEntity.status(HttpStatus.OK).body(new Response(lotAppelOffreService.afficherLotsAppelOffre(), new Date()));
	}
	
	@PostMapping("/ajouterLotAppelOffre")
	public ResponseEntity<LotAppelOffre> ajouterLotAppelOffre(@RequestBody LotAppelOffre lotAppelOffre) {
	
		String appelOffreCode = null;
		List<AppelOffre> liste = appelOffreService.appelOffreCourant();
		Iterator iter = liste.iterator();
		AppelOffre appelOffre = (AppelOffre) iter.next();
		if (lotAppelOffre != null) {
			lotAppelOffre.setAppel_offre(appelOffre);
			ResponseEntity<LotAppelOffre> responseCreate = ResponseEntity.status(HttpStatus.OK)
					.body(lotAppelOffreService.ajouterLotAppelOffre(lotAppelOffre));
			return responseCreate;
		} else {
			throw new ResourceNotFoundException("Can't create lotAppelOffre");
		}

	}
	
	@PostMapping("/modifierLotAppelOffre")
	public LotAppelOffre modifierLotAppelOffre(@RequestBody LotAppelOffre lotAppelOffre) {
		return lotAppelOffreService.modifierLotAppelOffre(lotAppelOffre);
	}
	
	@DeleteMapping("/supprimerLotAppelOffre")
	public HttpStatus supprimerLotAppelOffre(@RequestParam("code") String code) {
		if (code != null) {
			lotAppelOffreService.supprimerLotAppelOffre(code);
			HttpStatus responseDelete = HttpStatus.OK;
			return responseDelete;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}
	}

	@PostMapping("/selectLotAppelOffre")
	public LotAppelOffre selectLotAppelOffre(@RequestBody LotAppelOffre lotAppelOffre) {
		lotAppelOffreRepository.updateAll();
		lotAppelOffre.setCurrent(1);
    return lotAppelOffreService.modifierLotAppelOffre(lotAppelOffre);
	}

	@GetMapping("/rechercherLotAppelOffre/{recherche}")
    public List<LotAppelOffre> searchLotAppelOffre (@PathVariable(value="recherche") String recherche){
    	return lotAppelOffreService.searchLotAppelOffre(recherche);
    }
}
