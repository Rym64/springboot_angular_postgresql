package com.miniblog.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniblog.model.Comment;
import com.miniblog.model.Status;
import com.miniblog.model.User;
import com.miniblog.model.dto.CommentDTO;
import com.miniblog.repository.CommentRepository;
import com.miniblog.repository.StatusRepository;
import com.miniblog.repository.UserRepository;
import com.miniblog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	protected ModelMapper mapper;

	@Override
	public void addComment(CommentDTO commentDTO) {
		Optional<User> user = null;
		Optional<Status> status = null;
		Comment comment = this.mapper.map(commentDTO, Comment.class);
		
		if(commentDTO.getUser_id() != 0L) {
			user = userRepository.findById(commentDTO.getUser_id());
			if(user.get() != null) {
				comment.setUser(user.get());
			}
		}
		
		if(commentDTO.getStatus_id() != 0L) {
			status = statusRepository.findById(commentDTO.getStatus_id());
			if(status.get() != null) {
				comment.setStatus(status.get());
			}
		}
		
		commentRepository.save(comment);
		
	}

	@Override
	public void deleteComment(long id) {
		
		commentRepository.deleteById(id);
		
	}

}
