package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.NotFoundException;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;


@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
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
    public User createUser(@Validated @RequestBody User user) {
        return userRepository.save(user);
    }
    
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id,
                                   @Validated @RequestBody User userUpdated) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(userUpdated.getUsername());
                    user.setFirstname(userUpdated.getFirstname());
                    user.setLastname(userUpdated.getLastname());
                    user.setAddress(userUpdated.getAddress());
                    user.setPhone(userUpdated.getPhone());
                    user.setDatebirth(userUpdated.getDatebirth());
                    user.setEmail(userUpdated.getEmail());
                    user.setPassword(userUpdated.getPassword());
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