package com.stagePFE.cni.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stagePFE.cni.models.DemandeCG;
import com.stagePFE.cni.repository.DemandeCGRepository;
import com.stagePFE.cni.repository.UserRepository;


@RestController
public class DemandeCGController {
	
	@Autowired
	DemandeCGRepository demandecgRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/users/{userId}/cgrise")
    public DemandeCG createCgrise(@PathVariable(value = "userId") Long userId,
            @Valid @RequestBody DemandeCG cgrise) throws ResourceNotFoundException {
            return userRepository.findById(userId).map(user -> {
                cgrise.setUser(user);
                return demandecgRepository.save(cgrise);
            }).orElseThrow(() -> new ResourceNotFoundException("user not found"));
        }
	
	@GetMapping("/user/{userId}/cgrise")
	public List < DemandeCG > getCoursesByInstructor(@PathVariable(value = "userId") Long userId) {
        return demandecgRepository.findByUserId(userId);
    }
	
	
	@GetMapping("/user/{userId}/cgrise/{cgriseId}")
	public ResponseEntity<DemandeCG> getDemandeCGById(@PathVariable("id") long id) {
		Optional<DemandeCG> demandecgData = demandecgRepository.findById(id);

		if (demandecgData.isPresent()) {
			return new ResponseEntity<>(demandecgData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/user/{userId}/cgrise/{cgriseId}")
	public DemandeCG updateCgrise(@PathVariable(value = "userId") Long userId,
	        @PathVariable(value = "cgriseId") Long cgriseId, @Valid @RequestBody DemandeCG cgriseRequest)
	    throws ResourceNotFoundException {
	        if (!userRepository.existsById(userId)) {
	            throw new ResourceNotFoundException("userId not found");
	        }
	        return demandecgRepository.findById(cgriseId).map(cgrise -> {
	            cgrise.setCin(cgriseRequest.getCin());
	            cgrise.setPlacebirth(cgriseRequest.getPlacebirth());
	            cgrise.setNationality(cgriseRequest.getNationality());
	            cgrise.setCity(cgriseRequest.getCity());
	            cgrise.setPostalcode(cgriseRequest.getPostalcode());
	            return demandecgRepository.save(cgrise);
	        }).orElseThrow(() -> new ResourceNotFoundException("carte grise id not found"));
}
	
	@DeleteMapping("/user/{userId}/cgrise/{cgriseId}")
	public ResponseEntity < ? > deleteCgrise(@PathVariable(value = "userId") Long userId,
	        @PathVariable(value = "cgriseId") Long cgriseId) throws ResourceNotFoundException {
	        return demandecgRepository.findByIdAndUserId(cgriseId, userId).map(cgrise -> {
	        	demandecgRepository.delete(cgrise);
	            return ResponseEntity.ok().build();
	        }).orElseThrow(() -> new ResourceNotFoundException(
	            "Carte grise not found with id " + cgriseId + " and userId " + userId));
	    }

	}























