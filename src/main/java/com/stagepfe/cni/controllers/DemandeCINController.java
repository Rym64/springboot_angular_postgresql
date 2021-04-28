package com.stagepfe.cni.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stagepfe.cni.models.DemandeCIN;

import com.stagepfe.cni.repository.DemandeCinRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DemandeCINController {
	@Autowired
	DemandeCinRepository demandecinRepository;
	
	

	@GetMapping("/demandecins")
	public ResponseEntity<List<DemandeCIN>> getAllDemandeCIN(@RequestParam(required = false) String firstname) {
		try {
			List<DemandeCIN> demandecins = new ArrayList<DemandeCIN>();

			if (firstname == null)
				demandecinRepository.findAll().forEach(demandecins::add);
			else
				demandecinRepository.findByaddressContaining(firstname).forEach(demandecins::add);

			if (demandecins.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(demandecins, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/demandecins/{id}")
	public ResponseEntity<DemandeCIN> getDemandeCINById(@PathVariable("id") long id) {
		Optional<DemandeCIN> demandecniData = demandecinRepository.findById(id);

		if (demandecniData.isPresent()) {
			return new ResponseEntity<>(demandecniData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/demandecins")
	public ResponseEntity<DemandeCIN> createDemandeCIN(@RequestBody DemandeCIN demandecin) {
		try {
			DemandeCIN _demandecni = demandecinRepository
					.save(new DemandeCIN(demandecin.getFirstname(), demandecin.getLastname(),demandecin.getAddress(), demandecin.getPhone(), demandecin.getEmail(), demandecin.getDatebirth(), demandecin.getCity(), demandecin.getPlacebirth(), demandecin.getNationality(), demandecin.getPostalcode(), demandecin.getMothername(), demandecin.getFathername(), demandecin.getJob()));
			return new ResponseEntity<>( _demandecni, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	

	@PutMapping("/demandecins/{id}")
	public ResponseEntity<DemandeCIN> updateDemandeCIN(@PathVariable("id") long id, @RequestBody DemandeCIN demandecin) {
		Optional<DemandeCIN> demandecniData = demandecinRepository.findById(id);

		if (demandecniData.isPresent()) {
			DemandeCIN _demandecin = demandecniData.get();
			_demandecin.setFirstname(demandecin.getFirstname());
			_demandecin.setLastname(demandecin.getLastname());
			_demandecin.setAddress(demandecin.getAddress());
			_demandecin.setPhone(demandecin.getPhone());
			_demandecin.setDatebirth(demandecin.getDatebirth());
		
			_demandecin.setPlacebirth(demandecin.getPlacebirth());
			_demandecin.setNationality(demandecin.getNationality());
			_demandecin.setCity(demandecin.getCity());
			_demandecin.setPostalcode(demandecin.getPostalcode());
			_demandecin.setEmail(demandecin.getEmail());
			_demandecin.setFathername(demandecin.getFathername());
			_demandecin.setMothername(demandecin.getMothername());
			_demandecin.setJob(demandecin.getJob());
		
			
			return new ResponseEntity<>(demandecinRepository.save(_demandecin), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/demandecins/{id}")
	public ResponseEntity<HttpStatus> deleteDemandeCG(@PathVariable("id") long id) {
		try {
			demandecinRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/demandecins")
	public ResponseEntity<HttpStatus> deleteAllDemandeCINs() {
		try {
			demandecinRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}






















