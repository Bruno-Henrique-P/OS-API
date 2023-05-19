package com.bruno.OS.Resource.exceptions;

import java.io.Serializable;

public class StandartError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long timestamp;
	private Integer error; 
	private String message;
	
	public StandartError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandartError(long timestamp, Integer error, String message) {
		super();
		this.timestamp = timestamp;
		this.error = error;
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getError() {
		return error;
	}

	public void setError(Integer error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
