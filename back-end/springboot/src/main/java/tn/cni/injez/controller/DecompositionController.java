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
import tn.cni.injez.model.Decomposition;
import tn.cni.injez.model.Projet;
import tn.cni.injez.response.Response;
import tn.cni.injez.service.DecompositionService;
import tn.cni.injez.service.ProjetService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DecompositionController {
	@Autowired
	private DecompositionService decompositionService;
	@Autowired
	private ProjetService projetService;
	
	
	@GetMapping("/afficherDecompositions")
	public ResponseEntity<Response> afficherDecompositions() {
		
		return ResponseEntity.status(HttpStatus.OK).body(new Response(decompositionService.afficherDecompositions(), new Date()));
	}
	
	@PostMapping("/ajouterDecomposition")
	public ResponseEntity<Decomposition> ajouterDecomposition(@RequestBody Decomposition decomposition) {
		String projetCode = null;
		List<Projet> liste = projetService.projetCourant();
		Iterator iter = liste.iterator();
		Projet projet = (Projet) iter.next();
		if (decomposition != null) {
			decomposition.setProjet(projet);
			ResponseEntity<Decomposition> responseCreate = ResponseEntity.status(HttpStatus.OK)
					.body(decompositionService.ajouterDecomposition(decomposition));
			return responseCreate;
		} else {
			throw new ResourceNotFoundException("Can't create decomposition");
		}

	}
	
	@PostMapping("/modifierDecomposition")
	public Decomposition modifierDecomposition(@RequestBody Decomposition decomposition) {
		return decompositionService.modifierDecomposition(decomposition);
	}
	
	@DeleteMapping("/supprimerDecomposition")
	public HttpStatus supprimerDecomposition(@RequestParam("id") Integer id) {
		if (id != null) {
			decompositionService.supprimerDecomposition(id);
			HttpStatus responseDelete = HttpStatus.OK;
			return responseDelete;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}
	}
	
	@GetMapping("/rechercherDecomposition/{recherche}")
    public List<Decomposition> searchDecomposition (@PathVariable(value="recherche") String recherche){
    	return decompositionService.searchDecomposition(recherche);
    }
	
	
}
