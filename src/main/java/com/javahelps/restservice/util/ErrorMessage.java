package com.javahelps.restservice.util;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	private Date timestamp;
	private String message;
	private String details;
	private HttpStatus httpStatus;

	public ErrorMessage() {
	}

	public ErrorMessage(Date timestamp, HttpStatus httpStatus, String message) {
		this.timestamp = timestamp;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
