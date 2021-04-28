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
import com.stagepfe.cni.models.DemandeCG;
import com.stagepfe.cni.repository.DemandeCGRepository;


@RestController
@RequestMapping("/api")
public class DemandeCGController {
	@Autowired
	private DemandeCGRepository cgRepository;
	
	@Autowired
	private UserRepository userRepository;
	
    @GetMapping("/users/{userId}/cgrises")
    public List<DemandeCG> getContactByUserId(@PathVariable Long userId) {
    	
        if(!userRepository.existsById(userId)) {
            throw new NotFoundException("User not found!");
        }
    	
    	return cgRepository.findByUserId(userId);
    }
    
    @PostMapping("/users/{userId}/cgrises")
    public DemandeCG addCGrise(@PathVariable Long userId,
                            @Valid @RequestBody DemandeCG cg) {
        return userRepository.findById(userId)
                .map(user -> {
                    cg.setUser(user);
                    return cgRepository.save(cg);
                }).orElseThrow(() -> new NotFoundException("User not found!"));
    }
    
    @PutMapping("/users/{userId}/cgrises/{cgriseId}")
    public DemandeCG updateCGrise(@PathVariable Long userId,
    								@PathVariable Long cgriseId,
    								@Valid @RequestBody DemandeCG cgUpdated) {
    	
    	if(!userRepository.existsById(userId)) {
    		throw new NotFoundException("User not found!");
    	}
    	
        return cgRepository.findById(cgriseId)
                .map(cg -> {
                    cg.setPlacebirth(cgUpdated.getPlacebirth());
                    cg.setNationality(cgUpdated.getNationality());
                    cg.setCity(cgUpdated.getCity());
                    cg.setPostalcode(cgUpdated.getPostalcode());
                    return cgRepository.save(cg);
                }).orElseThrow(() -> new NotFoundException("Carte grise not found!"));
    }
    
    @DeleteMapping("/users/{userId}/cgrises/{cgriseId}")
    public String deleteCGrise(@PathVariable Long userId,
    							   @PathVariable Long cgriseId) {
    	
    	if(!userRepository.existsById(userId)) {
    		throw new NotFoundException("User not found!");
    	}
    	
        return cgRepository.findById(cgriseId)
                .map(cg -> {
                    cgRepository.delete(cg);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Contact not found!"));
    }
}
