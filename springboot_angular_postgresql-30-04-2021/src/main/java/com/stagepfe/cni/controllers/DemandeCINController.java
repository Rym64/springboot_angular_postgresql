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
import com.stagepfe.cni.models.DemandeCIN;

import com.stagepfe.cni.repository.DemandeCinRepository;
import com.stagepfe.cni.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class DemandeCINController {
	
	
	@Autowired
	private DemandeCinRepository demandecinRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/cins")
	public List<DemandeCIN> getAllCins(){
		return demandecinRepository.findAll();
	}
	
    @GetMapping("/users/{userId}/cins")
    public DemandeCIN getCinByUserId(@PathVariable Long userId) {
    	
        if(!userRepository.existsById(userId)) {
            throw new NotFoundException("User not found!");
        }
    	
    	List<DemandeCIN> cins = demandecinRepository.findByUserId(userId);
    	if(cins.size() > 0) {
    		return cins.get(0);
    	}else {
    		throw new NotFoundException("Cin not found!");
    	}
    	
    }
    
    @PostMapping("/users/{userId}/cins")
    public DemandeCIN addCin(@PathVariable Long userId,
                            @Valid @RequestBody DemandeCIN cin) {
        return userRepository.findById(userId)
                .map(user -> {
                    cin.setUser(user);
                    return demandecinRepository.save(cin);
                }).orElseThrow(() -> new NotFoundException("User not found!"));
    }
    
    @PutMapping("/cins/{cinId}")
    public DemandeCIN updateCin(@PathVariable Long cinId,
                               @Valid @RequestBody DemandeCIN cinUpdated) {
        return demandecinRepository.findById(cinId)
                .map(cin -> {
                    cin.setPlacebirth(cinUpdated.getPlacebirth());
                    cin.setNationality(cinUpdated.getNationality());
                    cin.setCity(cinUpdated.getCity());
                    cin.setPostalcode(cinUpdated.getPostalcode());  
                    cin.setMothername(cinUpdated.getMothername());
                    cin.setFathername(cinUpdated.getFathername());
                    cin.setJob(cinUpdated.getJob());

                    return demandecinRepository.save(cin);
                }).orElseThrow(() -> new NotFoundException("Cin not found!"));
    }
    
    @DeleteMapping("/cins/{cinId}")
    public String deleteCin(@PathVariable Long cinId) {
        return demandecinRepository.findById(cinId)
                .map(cin -> {
                	demandecinRepository.delete(cin);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Cin not found!"));
    }

}
