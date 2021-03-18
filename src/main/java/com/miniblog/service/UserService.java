package com.miniblog.service;

import com.miniblog.model.dto.UserDTO;
import com.miniblog.model.dto.UserInfoDTO;

public interface UserService {
	
	 UserInfoDTO findByEmail(String email);
	 UserDTO registerUser(UserDTO userDTO);
	 Boolean existsByEmail(UserDTO userDTO);
	    
}
