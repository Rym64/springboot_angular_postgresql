package com.example.stagePFE.model;

import java.util.ArrayList;
import java.util.List;

public class Message {
	private String message = "";
	private List<User> users = new ArrayList<User>();
	private String error = "";
	
	public Message(String message, List<User> users, String error) {
		this.message = message;
		this.users = users;
		this.error = error;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<User> getUsers(){
		return this.users;
	}
	
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public String getError() {
		return this.error;
	}
}