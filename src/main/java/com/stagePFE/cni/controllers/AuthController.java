package com.stagePFE.cni.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stagePFE.cni.models.ERole;
import com.stagePFE.cni.models.Role;
import com.stagePFE.cni.models.User;
import com.stagePFE.cni.payload.request.LoginRequest;
import com.stagePFE.cni.payload.request.SignupRequest;
import com.stagePFE.cni.payload.response.JwtResponse;
import com.stagePFE.cni.payload.response.MessageResponse;
import com.stagePFE.cni.repository.RoleRepository;
import com.stagePFE.cni.repository.UserRepository;
import com.stagePFE.cni.security.jwt.JwtUtils;
import com.stagePFE.cni.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(),
				             signUpRequest.getImage(),
				             signUpRequest.getAddress(), 
				             signUpRequest.getPhone(),
				             signUpRequest.getDatebirth(),
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		
		/*String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role citoyenRole = roleRepository.findByName(ERole.CITOYEN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(citoyenRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "agent":
					Role agentRole = roleRepository.findByName(ERole.AGENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(agentRole);

					break;
				default:
					Role citoyenRole = roleRepository.findByName(ERole.CITOYEN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(citoyenRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		//String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
//jwt, 
		return ResponseEntity.ok(new JwtResponse(
												 userDetails.getId(),												 
												 userDetails.getUsername(),
												 userDetails.getImage(),
												 userDetails.getAddress(), 
												 userDetails.getPhone(), 
												 userDetails.getDatebirth(), 
												 userDetails.getEmail(), 
												 roles));
	}

	
}
