package com.bezkoder.springjwt.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.DemandeCG;
import com.bezkoder.springjwt.repository.DemandeCGRepository;


@RestController
@RequestMapping("/api")
public class DemandeCGController {
	@Autowired
	DemandeCGRepository demandecgRepository;
	
	

	@GetMapping("/demandecgs")
	public ResponseEntity<List<DemandeCG>> getAllDemandeCG(@RequestParam(required = false) String firstname) {
		try {
			List<DemandeCG> demandecgs = new ArrayList<DemandeCG>();

			if (firstname == null)
				demandecgRepository.findAll().forEach(demandecgs::add);
			else
				demandecgRepository.findByaddressContaining(firstname).forEach(demandecgs::add);

			if (demandecgs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(demandecgs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/demandecgs/{id}")
	public ResponseEntity<DemandeCG> getDemandeCGById(@PathVariable("id") long id) {
		Optional<DemandeCG> demandecgData = demandecgRepository.findById(id);

		if (demandecgData.isPresent()) {
			return new ResponseEntity<>(demandecgData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/demandecgs")
	public ResponseEntity<DemandeCG> createDemandeCG(@RequestBody DemandeCG demandecg) {
		try {
			DemandeCG _demandecg = demandecgRepository
					.save(new DemandeCG(demandecg.getFirstname(), demandecg.getLastname(),demandecg.getAddress(), demandecg.getPhone(), demandecg.getEmail(), demandecg.getDatebirth(), demandecg.getCity(), demandecg.getPlacebirth(), demandecg.getNationality(), demandecg.getPostalcode(), demandecg.getCin ()));
			return new ResponseEntity<>( _demandecg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	

	@PutMapping("/demandecgs/{id}")
	public ResponseEntity<DemandeCG> updateDemandeCG(@PathVariable("id") long id, @RequestBody DemandeCG demandecg) {
		Optional<DemandeCG> demandecgData = demandecgRepository.findById(id);

		if (demandecgData.isPresent()) {
			DemandeCG _demandecg = demandecgData.get();
			_demandecg.setFirstname(demandecg.getFirstname());
			_demandecg.setLastname(demandecg.getLastname());
			_demandecg.setAddress(demandecg.getAddress());
			_demandecg.setPhone(demandecg.getPhone());
			_demandecg.setDatebirth(demandecg.getDatebirth());
			_demandecg.setCin(demandecg.getCin());
			_demandecg.setPlacebirth(demandecg.getPlacebirth());
			_demandecg.setNationality(demandecg.getNationality());
			_demandecg.setCity(demandecg.getCity());
			_demandecg.setPostalcode(demandecg.getPostalcode());
			_demandecg.setEmail(demandecg.getEmail());
		
			
			return new ResponseEntity<>(demandecgRepository.save(_demandecg), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/demandecgs/{id}")
	public ResponseEntity<HttpStatus> deleteDemandeCG(@PathVariable("id") long id) {
		try {
			demandecgRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/demandecgs")
	public ResponseEntity<HttpStatus> deleteAllDemandeCGs() {
		try {
			demandecgRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}






















