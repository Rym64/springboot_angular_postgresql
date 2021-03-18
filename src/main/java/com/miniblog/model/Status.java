package com.miniblog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="status")
public class Status implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "text_status")
	private String textStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private Date createdAt;
	
	 @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<Comment> comments;
	 
	 @JoinColumn(name = "user_id", referencedColumnName = "id")
	 @ManyToOne
	 private User user;
	 
	 public Status() {}

	 public Status(@NotBlank String textStatus, Date createdAt, List<Comment> comments, User user) {
		super();
		this.textStatus = textStatus;
		this.createdAt = createdAt;
		this.comments = comments;
		this.user = user;
	 }

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

	 public User getUser() {
		return user;
	 }
	
	 public void setUser(User user) {
		this.user = user;
	 }

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
