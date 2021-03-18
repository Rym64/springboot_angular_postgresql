package com.miniblog.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.miniblog.model.User;
import com.miniblog.model.dto.UserDTO;
import com.miniblog.model.dto.UserInfoDTO;
import com.miniblog.repository.UserRepository;
import com.miniblog.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	protected ModelMapper mapper;

	@Override
	public UserInfoDTO findByEmail(String email) {
		
		Optional<User> user = userRepository.findByEmail(email);
		
		UserInfoDTO userDto = this.mapper.map(user.get(), UserInfoDTO.class);
		
		return userDto;
	}

	@Override
	public UserDTO registerUser(UserDTO userDTO) {
		
		User newUser = this.mapper.map(userDTO, User.class);
		 
		newUser.setPassword(encoder.encode(userDTO.getPassword()));
		
		User newAddedUser = this.userRepository.save(newUser);
		
		return this.mapper.map(newAddedUser, UserDTO.class);
		
	}

	@Override
	public Boolean existsByEmail(UserDTO userDTO) {
		return userRepository.existsByEmail(userDTO.getEmail());
	}

}
