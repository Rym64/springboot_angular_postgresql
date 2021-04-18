package com.bezkoder.springjwt.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.UserRequest;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	@PostMapping("/users/add")
	public ResponseEntity<?> addUser(@Valid @RequestBody UserRequest userRequest) {
		if (userRepository.existsByUsername(userRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(userRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(userRequest.getUsername(), 
				             userRequest.getAddress(), 
				             userRequest.getPhone(),
				             userRequest.getDatebirth(),
				             userRequest.getEmail(),
							 encoder.encode(userRequest.getPassword()));

		Set<String> strRoles = userRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role citoyenRole = roleRepository.findByName(ERole.ROLE_CITOYEN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(citoyenRole);
		} else {
			strRoles.forEach(role -> {
					Role citoyenRole = roleRepository.findByName(ERole.ROLE_CITOYEN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(citoyenRole);
				
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("Citoyen added successfully!"));
	}
	
	

	@GetMapping("/users/getall")
	public ResponseEntity<List<User>> getAllUser(@RequestParam(required = false) String username) {
		try {
			List<User> user = new ArrayList<User>();

			if (username == null)
				userRepository.findAll().forEach(user::add);
			else
				userRepository.findByUsernameContaining(username).forEach(user::add);

			if (user.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/users/findone/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		Optional<User> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/users/edit/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		Optional<User> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setUsername(user.getUsername());
			_user.setAddress(user.getAddress());
			_user.setPhone(user.getPhone());
			_user.setDatebirth(user.getDatebirth());
			_user.setEmail(user.getEmail());
			_user.setPassword(user.getPassword());
			
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/users/deletebyid/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
		try {
			userRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/users/deleteall")
	public ResponseEntity<HttpStatus> deleteAllUsers() {
		try {
			userRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
