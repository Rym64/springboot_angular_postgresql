package com.miniblog.service;

import com.miniblog.model.dto.CommentDTO;

public interface CommentService {
	
	void addComment(CommentDTO commentDTO);
	void deleteComment(long id);
	
}
