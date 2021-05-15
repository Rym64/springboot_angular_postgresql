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
import com.stagepfe.cni.models.FinanceV;
import com.stagepfe.cni.repository.FinanceVRepository;
import com.stagepfe.cni.repository.VehiculeRepository;


@RestController
@RequestMapping("/api")
public class FinanceVController {
	@Autowired
	private FinanceVRepository financeRepository;
	
	@Autowired
	private VehiculeRepository vehiculeRepository;
	
    @GetMapping("/vehicules/{vehiculeId}/financevs")
    public List<FinanceV> getContactByVehiculeId(@PathVariable Long vehiculeId) {
    	
        if(!vehiculeRepository.existsById(vehiculeId)) {
            throw new NotFoundException("Vehicule not found!");
        }
    	
    	return financeRepository.findByVehiculeId(vehiculeId);
    }
    
    @PostMapping("/vehicules/{vehiculeId}/financevs")
    public FinanceV addFinanceV(@PathVariable Long vehiculeId,
                            @Valid @RequestBody FinanceV fv) {
        return vehiculeRepository.findById(vehiculeId)
                .map(vehicule -> {
                    fv.setVehicule(vehicule);
                    return financeRepository.save(fv);
                }).orElseThrow(() -> new NotFoundException("Vehicule not found!"));
    }
    
    @PutMapping("/vehicules/{vehiculeId}/financevs/{financeId}")
    public FinanceV updateFinanceV(@PathVariable Long vehiculeId,
    								@PathVariable Long financeId,
    								@Valid @RequestBody FinanceV fvUpdated) {
    	
    	if(!vehiculeRepository.existsById(vehiculeId)) {
    		throw new NotFoundException("Vehicule not found!");
    	}
    	
        return financeRepository.findById(financeId)
                .map(fv -> {
                    fv.setAnneeV(fvUpdated.getAnneeV());
                    fv.setPeriodeV(fvUpdated.getPeriodeV());
                    return financeRepository.save(fv);
                }).orElseThrow(() -> new NotFoundException("Finance not found!"));
    }
    
    @DeleteMapping("/vehicules/{vehiculeId}/financevs/{financevId}")
    public String deleteFinanceV(@PathVariable Long vehiculeId,
    							   @PathVariable Long financevId) {
    	
    	if(!vehiculeRepository.existsById(vehiculeId)) {
    		throw new NotFoundException("Vehicule not found!");
    	}
    	
        return financeRepository.findById(financevId)
                .map(fn -> {
                    financeRepository.delete(fn);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Contact not found!"));
    }
}
