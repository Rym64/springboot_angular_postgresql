package com.stagepfe.cni.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stagepfe.cni.models.ERole;
import com.stagepfe.cni.payload.request.UserRequest;
import com.stagepfe.cni.payload.response.MessageResponse;
import com.stagepfe.cni.exception.NotFoundException;
import com.stagepfe.cni.models.Role;
import com.stagepfe.cni.models.User;
import com.stagepfe.cni.repository.RoleRepository;
import com.stagepfe.cni.repository.UserRepository;


@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
    @GetMapping("/users")
    public List<User> getAllUsers() {
    	return userRepository.findAll();
    }
    
    @GetMapping("/users/{id}")
    public User getUserByID(@PathVariable Long id) {
    	Optional<User> optUser = userRepository.findById(id);
    	if(optUser.isPresent()) {
    		return optUser.get();
    	}else {
    		throw new NotFoundException("User not found with id " + id);
    	}
    }
    
    @PostMapping("/users")
	public ResponseEntity<?> addUser(@Valid @RequestBody UserRequest userRequest) { //,@RequestParam("file") MultipartFile file
		
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

		// added new user
		User user = new User(userRequest.getUsername(),
				             userRequest.getFirstname(),
				             userRequest.getLastname(),
                             userRequest.getImage(),
	                         userRequest.getAddress(),
	                         userRequest.getPhone(),
	                         userRequest.getDatebirth(),
	                         userRequest.getEmail(),	             
				             encoder.encode(userRequest.getPassword()));
		
		Set<String> strRoles = userRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role citoyenRole = roleRepository.findByName(ERole.Citoyen)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(citoyenRole);
		} else {
			strRoles.forEach(role -> {
					Role citoyenRole = roleRepository.findByName(ERole.Citoyen)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(citoyenRole);
				
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("Citoyen added successfully!"));
	}
    
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id,
                                   @Valid @RequestBody User userUpdated) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(userUpdated.getUsername());
                    user.setFirstname(userUpdated.getFirstname());
                    user.setLastname(userUpdated.getLastname());
                    user.setImage(userUpdated.getImage());
                    user.setAddress(userUpdated.getAddress());
                    user.setPhone(userUpdated.getPhone());
                    user.setDatebirth(userUpdated.getDatebirth());
                    user.setEmail(userUpdated.getEmail());
                    user.setPassword(encoder.encode(userUpdated.getPassword()));
                    return userRepository.save(user);
                }).orElseThrow(() -> new NotFoundException("User not found with id " + id));
    }
    
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return "Delete Successfully!";
                }).orElseThrow(() -> new NotFoundException("User not found with id " + id));
    }
 
}