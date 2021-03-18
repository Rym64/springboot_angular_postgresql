package com.miniblog.model.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

public class StatusInfoDTO {
	
	private Long id;
	
    private String textStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	private List<CommentInfoDTO> comments;
	
	private UserInfoDTO user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTextStatus() {
		return textStatus;
	}

	public void setTextStatus(String textStatus) {
		this.textStatus = textStatus;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<CommentInfoDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentInfoDTO> comments) {
		this.comments = comments;
	}

	public UserInfoDTO getUser() {
		return user;
	}

	public void setUser(UserInfoDTO user) {
		this.user = user;
	}
	
}
