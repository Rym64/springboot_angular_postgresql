package com.example.stagePFE.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stagePFE.service.ServiceUser;
import com.example.stagePFE.model.Message;
import com.example.stagePFE.model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	ServiceUser userServices;
	
	@PostMapping("/create")
	public ResponseEntity<Message> addNewUser(@RequestBody User user) {
		try {
			User returnedUser = userServices.saveUser(user);
			
			return new ResponseEntity<Message>(new Message("Upload Successfully!", 
											Arrays.asList(returnedUser), ""), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Fail to post a new User!", 
											null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
	
	@GetMapping("/retrieveinfos")
	public ResponseEntity<Message> retrieveUserInfo() {
		
		try {
			List<User> userInfos = userServices.getUserInfos();
			
			return new ResponseEntity<Message>(new Message("Get Users' Infos!", 
												userInfos, ""), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Fail!",
												null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findone/{id}")
	public ResponseEntity<Message> getUserById(@PathVariable long id) {
		try {
			Optional<User> optUser = userServices.getUserById(id);
			
			if(optUser.isPresent()) {
				return new ResponseEntity<Message>(new Message("Successfully! Retrieve a user by id = " + id,
															Arrays.asList(optUser.get()), ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(new Message("Failure -> NOT Found a user by id = " + id,
						null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Failure",
					null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Message> updateUserById(@RequestBody User _user, 
																	@PathVariable long id) {
		try {
			if(userServices.checkExistedUser(id)) {
				User user = userServices.getUserById(id).get();
				
				//set new values for customer
				user.setFirstname(_user.getFirstname());
				user.setLastname(_user.getLastname());
				user.setAddress(_user.getAddress());
				user.setPhone(_user.getPhone());
				user.setEmail(_user.getEmail());
				user.setPassword(_user.getPassword());
	
				// save the change to database
				userServices.updateUser(user);
				
				return new ResponseEntity<Message>(new Message("Successfully! Updated a user "
																		+ "with id = " + id,
																	Arrays.asList(user), ""), HttpStatus.OK);
			}else {
				return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a user "
						+ "with id = " + id,
					null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Failure",
					null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Message> deleteUserById(@PathVariable long id) {
		try {
			// checking the existed of a User with id
			if(userServices.checkExistedUser(id)) {
				userServices.deleteUserById(id);
				
				return new ResponseEntity<Message> (new Message("Successfully! Delete a User with id = " + id, 
														null, ""), HttpStatus.OK);
			}else {
				return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a User "
														+ "with id = " + id, null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Failure",
					null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}