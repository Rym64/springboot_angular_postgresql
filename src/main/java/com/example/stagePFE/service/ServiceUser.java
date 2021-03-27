package com.example.stagePFE.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stagePFE.model.User;
import com.example.stagePFE.repository.UserRepository;

@Service
public class ServiceUser {
	
		@Autowired 
		UserRepository repository;
		
		public User saveUser(User user) {
			return repository.save(user);
		}
		
		public List<User> getUserInfos(){
			return repository.findAll();
		}
		
		public Optional<User> getUserById(long id) {
			return repository.findById(id);
		}
		
		public boolean checkExistedUser(long id) {
			if(repository.existsById((long) id)) {
				return true;
			}
			return false;
		}
		
		public User updateUser(User user) {
			return repository.save(user);		
		}
		
		public void deleteUserById(long id) {
			repository.deleteById(id);
		}
	}
