package com.example.demo.controller;
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


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
 



@CrossOrigin(origins = "http://localhost:8087")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String firstname) {
		try {
			List<User> users = new ArrayList<User>();

			if (firstname == null)
				userRepository.findAll().forEach(users::add);
			else
				userRepository.findByadressContaining(firstname).forEach(users::add);

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getTutorialById(@PathVariable("id") long id) {
		Optional<User> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/users")
	public ResponseEntity<User> createTutorial(@RequestBody User user) {
		try {
			User _user = userRepository
					.save(new User(user.getFirstname(), user.getAdress(), user.getLastname(),user.getAdress(), user.getPhone()));
			return new ResponseEntity<>( _user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		Optional<User> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setFirstname(user.getFirstname());
			_user.setLastname(user.getLastname());
			_user.setAdress(user.getAdress());
			_user.setPhone(user.getPhone());
			
			
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			userRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/users")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			userRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
