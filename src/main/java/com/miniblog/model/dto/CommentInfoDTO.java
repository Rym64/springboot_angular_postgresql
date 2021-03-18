package com.miniblog.model.dto;

import java.util.Date;

public class CommentInfoDTO {
	
	private Long id;
	
    private String textComment;

	private Date createdAt;

	private UserInfoDTO user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTextComment() {
		return textComment;
	}

	public void setTextComment(String textComment) {
		this.textComment = textComment;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public UserInfoDTO getUser() {
		return user;
	}

	public void setUser(UserInfoDTO user) {
		this.user = user;
	}
	
}
