package tn.cni.injez.response;

import java.util.Date;

public class Response {

	// Generate Getters and Setters...
	private Object data;
	private Date date;
	private String message;

	public Response(Object data, Date date) {
		super();
		this.data = data;
		this.date = date;
	}
	
	public Response(String message) {
		super();
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
