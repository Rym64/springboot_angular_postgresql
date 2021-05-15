package com.stagepfe.cni.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stagepfe.cni.exception.NotFoundException;
import com.stagepfe.cni.models.ETypeV;
import com.stagepfe.cni.models.TypeEm;
import com.stagepfe.cni.models.Vehicule;
import com.stagepfe.cni.payload.request.VehiculeRequest;
import com.stagepfe.cni.payload.response.MessageResponse;
import com.stagepfe.cni.repository.TypeEmRepository;
import com.stagepfe.cni.repository.VehiculeRepository;

@RestController
@RequestMapping("/api")
public class VehiculeController {
	@Autowired
	VehiculeRepository vehiculeRepository;

	@Autowired
	TypeEmRepository typeRepository;

	@PostMapping("/vehicules")
	public ResponseEntity<?> addVehicule(@Valid @RequestBody VehiculeRequest vehiculeRequest) {

		if (vehiculeRepository.existsByImmatD(vehiculeRequest.getImmatD())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: ImmatD is already in use!"));
		}

		Vehicule vehicule = new Vehicule(
				             vehiculeRequest.getDmc(),                 
				             vehiculeRequest.getImmatD(),
				             vehiculeRequest.getImmatG()
				            );
		Set<String> strTypes = vehiculeRequest.getType();
		Set<TypeEm> types = new HashSet<>();

		if (strTypes == null) {
			TypeEm tu = typeRepository.findByType(ETypeV.TU)
					.orElseThrow(() -> new RuntimeException("Error: Type is not found."));
			types.add(tu);
		} else {
			strTypes.forEach(type -> {
				switch (type) {
				case "rs":
					TypeEm rs = typeRepository.findByType(ETypeV.RS)
							.orElseThrow(() -> new RuntimeException("Error: Type is not found."));
					types.add(rs);

					break;
				case "moto":
					TypeEm moto = typeRepository.findByType(ETypeV.MOTO)
							.orElseThrow(() -> new RuntimeException("Error: Type is not found."));
					types.add(moto);

					break;
				case "rem":
					TypeEm rem = typeRepository.findByType(ETypeV.REM)
							.orElseThrow(() -> new RuntimeException("Error: Type is not found."));
					types.add(rem);

					break;
				case "trac":
					TypeEm trac = typeRepository.findByType(ETypeV.TRAC)
							.orElseThrow(() -> new RuntimeException("Error: Type is not found."));
					types.add(trac);

					break;
				default:
					TypeEm tu = typeRepository.findByType(ETypeV.TU)
							.orElseThrow(() -> new RuntimeException("Error: Type is not found."));
					types.add(tu);
				}
			});
		}
		vehicule.setType(types);
		vehiculeRepository.save(vehicule);

		return ResponseEntity.ok(new MessageResponse("Vehicule added successfully!"));

	}
	
	
	 @GetMapping("/vehicules")
	    public List<Vehicule> getAllVehicules() {
	    	return vehiculeRepository.findAll();
	    }
	 
	 
	 @GetMapping("/vehicules/{id}")
	    public Vehicule getVehiculeByID(@PathVariable Long id) {
	    	Optional<Vehicule> optVehicule = vehiculeRepository.findById(id);
	    	if(optVehicule.isPresent()) {
	    		return optVehicule.get();
	    	}else {
	    		throw new NotFoundException("Vehicule not found with id " + id);
	    	}
	    }
	 
	 
	 @PutMapping("/vehicules/{id}")
	    public Vehicule updateVehicule(@PathVariable Long id,
	                                   @Valid @RequestBody Vehicule vehiculeUpdated) {
	        return vehiculeRepository.findById(id)
	                .map(vehicule -> {
	                	vehicule.setDmc(vehiculeUpdated.getDmc());
	                	vehicule.setImmatD(vehiculeUpdated.getImmatD());
	                	vehicule.setImmatG(vehiculeUpdated.getImmatG());
	                   
	                    return vehiculeRepository.save(vehicule);
	                }).orElseThrow(() -> new NotFoundException("Vehicule not found with id " + id));
	    }
	    
	 
	    @DeleteMapping("/vehicules/{id}")
	    public String deleteVehicule(@PathVariable Long id) {
	        return vehiculeRepository.findById(id)
	                .map(vehicule -> {
	                	vehiculeRepository.delete(vehicule);
	                    return "Delete Successfully!";
	                }).orElseThrow(() -> new NotFoundException("Vehicule not found with id " + id));
	    }
	 
}
