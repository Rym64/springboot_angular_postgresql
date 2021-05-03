package com.stagepfe.cni.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stagepfe.cni.exception.NotFoundException;
import com.stagepfe.cni.models.DemandeV;
import com.stagepfe.cni.repository.DemandeVRepository;
import com.stagepfe.cni.repository.VehiculeRepository;




@RestController
@RequestMapping("/api")
public class DemandeVController {

	@Autowired
	private DemandeVRepository demandeRepository;
	
	@Autowired
	private VehiculeRepository vehiculeRepository;
	
	@GetMapping("/vehicules/{vehiculeId}/demandevs")
    public List<DemandeV> getContactByVehiculeId(@PathVariable Long vehiculeId) {
    	
        if(!vehiculeRepository.existsById(vehiculeId)) {
            throw new NotFoundException("Vehicule not found!");
        }
    	
    	return demandeRepository.findByVehiculeId(vehiculeId);
    }
    
    @PostMapping("/vehicules/{vehiculeId}/demandevs")
    public DemandeV addDemandeV(@PathVariable Long vehiculeId,
                            @Valid @RequestBody DemandeV dv) {
        return vehiculeRepository.findById(vehiculeId)
                .map(vehicule -> {
                    dv.setVehicule(vehicule);
                    return demandeRepository.save(dv);
                }).orElseThrow(() -> new NotFoundException("Vehicule not found!"));
    }
    
    @PutMapping("/vehicules/{vehiculeId}/demandevs/{demandevId}")
    public DemandeV updateDemandeV(@PathVariable Long vehiculeId,
    								@PathVariable Long demandeId,
    								@Valid @RequestBody DemandeV dvUpdated) {
    	
    	if(!vehiculeRepository.existsById(vehiculeId)) {
    		throw new NotFoundException("Vehicule not found!");
    	}
    	
        return demandeRepository.findById(demandeId)
                .map(dv -> {
                    dv.setEtatdemande(dvUpdated.getEtatdemande());
                    return demandeRepository.save(dv);
                }).orElseThrow(() -> new NotFoundException("demande not found!"));
    }
    
    @DeleteMapping("/vehicules/{vehiculeId}/demandevs/{demandevId}")
    public String deleteFinanceV(@PathVariable Long vehiculeId,
    							   @PathVariable Long demandevId) {
    	
    	if(!vehiculeRepository.existsById(vehiculeId)) {
    		throw new NotFoundException("Vehicule not found!");
    	}
    	
        return demandeRepository.findById(demandevId)
                .map(dm -> {
                    demandeRepository.delete(dm);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Contact not found!"));
    }
}
	
	
	
	
