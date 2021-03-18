package com.miniblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniblog.model.dto.CommentDTO;
import com.miniblog.security.jwt.ResponseMessage;
import com.miniblog.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping
    public ResponseEntity<?> createComment(@RequestBody CommentDTO commentDTO) {
		try {
		commentService.addComment(commentDTO);
        return new ResponseEntity<>(new ResponseMessage("Comment added successfully!"), HttpStatus.OK);
		} catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") long id) {
	    try {
	    	commentService.deleteComment(id);
	    	return new ResponseEntity<>(new ResponseMessage("Comment deleted successfully"), HttpStatus.OK);
	    } catch (Exception e) {
		   return new ResponseEntity<>(new ResponseMessage("Error try again"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
 	}
}
