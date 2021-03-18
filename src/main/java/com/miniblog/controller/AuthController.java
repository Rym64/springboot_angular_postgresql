package com.miniblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniblog.model.dto.UserDTO;
import com.miniblog.model.dto.UserInfoDTO;
import com.miniblog.model.dto.UserLoginDTO;
import com.miniblog.security.jwt.JwtProvider;
import com.miniblog.security.jwt.JwtResponse;
import com.miniblog.security.jwt.ResponseMessage;
import com.miniblog.service.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserService userService;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserLoginDTO loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		UserInfoDTO userInfo = userService.findByEmail(userDetails.getUsername());
		
		return ResponseEntity.ok(new JwtResponse(jwt, userInfo));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO signUpRequest) {
	
		if (userService.existsByEmail(signUpRequest)) {
			return new ResponseEntity<>(new ResponseMessage("Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		try {
		      userService.registerUser(signUpRequest);
			  return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
			  
		} catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}