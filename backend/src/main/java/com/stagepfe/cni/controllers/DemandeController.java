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
import com.stagepfe.cni.repository.UserRepository;
import com.stagepfe.cni.models.Demande;
import com.stagepfe.cni.repository.DemandeRepository;

@RestController
@RequestMapping("/api")
public class DemandeController {
	@Autowired
	private DemandeRepository demandeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
    @GetMapping("/users/{userId}/getdemandes")
    public List<Demande> getDemandeByUserId(@PathVariable Long userId) {
    	
        if(!userRepository.existsById(userId)) {
            throw new NotFoundException("User not found!");
        }
    	
    	return demandeRepository.findByUserId(userId);
    }
    
    @PostMapping("/users/{userId}/adddemandes")
    public Demande addDemande(@PathVariable Long userId,
                            @Valid @RequestBody Demande demande) {
        return userRepository.findById(userId)
                .map(user -> {
                    demande.setUser(user);
                    return demandeRepository.save(demande);
                }).orElseThrow(() -> new NotFoundException("User not found!"));
    }
    
    @PutMapping("/users/{userId}/editdemande/{demandeId}")
    public Demande updateCGrise(@PathVariable Long userId,
    								@PathVariable Long demandeId,
    								@Valid @RequestBody Demande demandeUpdated) {
    	
    	if(!userRepository.existsById(userId)) {
    		throw new NotFoundException("User not found!");
    	}
    	
        return demandeRepository.findById(demandeId)
                .map(demande -> {
                	demande.setType(demandeUpdated.getType()); 
                	demande.setEtat(demandeUpdated.getEtat()); 
                    return demandeRepository.save(demande);
                }).orElseThrow(() -> new NotFoundException("Demande not found!"));
    }
    
    @DeleteMapping("/users/{userId}/deletedemandes/{demandeId}")
    public String deleteCGrise(@PathVariable Long userId,
    							   @PathVariable Long demandeId) {
    	
    	if(!userRepository.existsById(userId)) {
    		throw new NotFoundException("User not found!");
    	}
    	
        return demandeRepository.findById(demandeId)
                .map(demande -> {
                	demandeRepository.delete(demande);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Contact not found!"));
    }
}
