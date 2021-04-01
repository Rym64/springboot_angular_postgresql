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
import tn.cni.injez.model.Facture;
import tn.cni.injez.response.Response;
import tn.cni.injez.model.Marche;
import tn.cni.injez.service.FactureService;
import tn.cni.injez.service.MarcheService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FactureController {
	@Autowired
	private FactureService factureService;
	@Autowired
	private MarcheService marcheService;
	
	
	@GetMapping("/afficherFactures")
	public ResponseEntity<Response> afficherFactures() {
		return ResponseEntity.status(HttpStatus.OK).body(new Response(factureService.afficherFactures(), new Date()));
	}
	
	@PostMapping("/ajouterFacture")
	public ResponseEntity<Facture> ajouterFacture(@RequestBody Facture facture) {
		String marcheCode = null;
		List<Marche> liste = marcheService.marcheCourant();
		Iterator iter = liste.iterator();
		Marche marche = (Marche) iter.next();
		if (facture != null) {
			facture.setMarche(marche);
			ResponseEntity<Facture> responseCreate = ResponseEntity.status(HttpStatus.OK)
					.body(factureService.ajouterFacture(facture));
			return responseCreate;
		} else {
			throw new ResourceNotFoundException("Can't create facture");
		}

	}
	
	@PostMapping("/modifierFacture")
	public Facture modifierFacture(@RequestBody Facture facture) {
		return factureService.modifierFacture(facture);
	}
	
	@DeleteMapping("/supprimerFacture")
	public HttpStatus supprimerFacture(@RequestParam("code") String code) {
		if (code != null) {
			factureService.supprimerFacture(code);
			HttpStatus responseDelete = HttpStatus.OK;
			return responseDelete;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}
	}
	
	@GetMapping("/rechercherFacture/{recherche}")
    public List<Facture> searchMarche (@PathVariable(value="recherche") String recherche){
    	return factureService.searchFacture(recherche);
    }


}
