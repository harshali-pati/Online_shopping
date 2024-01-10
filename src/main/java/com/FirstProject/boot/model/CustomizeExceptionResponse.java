package com.FirstProject.boot.model;

import java.util.Date;

public class CustomizeExceptionResponse {
  
	private String defaultMessage;
	private int statuscode;
	private Date date;
	
	
	public CustomizeExceptionResponse() {		
	}


	public String getDefaultMessage() {
		return defaultMessage;
	}


	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}


	public int getStatuscode() {
		return statuscode;
	}


	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
