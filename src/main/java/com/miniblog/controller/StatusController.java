package com.miniblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniblog.model.dto.StatusDTO;
import com.miniblog.model.dto.StatusInfoDTO;
import com.miniblog.security.jwt.ResponseMessage;
import com.miniblog.service.StatusService;

@RestController
@RequestMapping("/api/status")
public class StatusController {
	
	@Autowired
	StatusService statusService;
	
	
	@GetMapping
    public ResponseEntity<List<StatusInfoDTO>> getAllEmployees() {
        List<StatusInfoDTO> list = statusService.getAllStatus();
 
        return new ResponseEntity<List<StatusInfoDTO>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	@PostMapping
    public ResponseEntity<?> createStatus(@RequestBody StatusDTO statusDTO) {
		try {
			statusService.addStatus(statusDTO);
        return new ResponseEntity<>(new ResponseMessage("Status posted successfully!"), HttpStatus.OK);
		} catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStatus(@PathVariable("id") long id) {
	    try {
	    	statusService.deleteStatus(id);
	      return new ResponseEntity<>(new ResponseMessage("Status deleted successfully"), HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(new ResponseMessage("Error try again"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
 	}

}
