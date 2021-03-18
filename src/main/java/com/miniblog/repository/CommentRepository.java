package com.miniblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniblog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
