package com.miniblog.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniblog.model.Comment;
import com.miniblog.model.Status;
import com.miniblog.model.User;
import com.miniblog.model.dto.CommentInfoDTO;
import com.miniblog.model.dto.StatusDTO;
import com.miniblog.model.dto.StatusInfoDTO;
import com.miniblog.model.dto.UserInfoDTO;
import com.miniblog.repository.StatusRepository;
import com.miniblog.repository.UserRepository;
import com.miniblog.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService{
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	protected ModelMapper mapper;
	
	@Override
	public List<StatusInfoDTO> getAllStatus() {
		List<StatusInfoDTO> statusInfoDTOs = new ArrayList<StatusInfoDTO>();
		List<Status> listStatus = statusRepository.findAll();
		
		listStatus.forEach(status -> {
			List<CommentInfoDTO> commentInfoDTOs = new ArrayList<CommentInfoDTO>(); 
			
			if(status.getComments() != null && !status.getComments().isEmpty()) {
				List<Comment> comments = status.getComments();
				
				comments.forEach(comment -> {
					CommentInfoDTO commentInfoDTO = this.mapper.map(comment, CommentInfoDTO.class);
					
					UserInfoDTO user = this.mapper.map(comment.getUser(), UserInfoDTO.class);
					commentInfoDTO.setUser(user);
				
					commentInfoDTOs.add(commentInfoDTO);
				});
			}

			StatusInfoDTO statusInfoDTO = this.mapper.map(status, StatusInfoDTO.class);
			statusInfoDTO.setComments(commentInfoDTOs);
			statusInfoDTOs.add(statusInfoDTO);
		});
		
		return statusInfoDTOs;
	}

	@Override
	public void addStatus(StatusDTO statusDTO) {
		Optional<User> user = null;
		Status status = this.mapper.map(statusDTO, Status.class);
		
		if(statusDTO.getUser_id() != 0L) {
			user = userRepository.findById(statusDTO.getUser_id());
			if(user.get() != null) {
				status.setUser(user.get());
			}
		}
		
		statusRepository.save(status);
		
	}

	@Override
	public void deleteStatus(long id) {
		
		statusRepository.deleteById(id);
		
	}

}
