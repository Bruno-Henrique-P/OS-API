package com.bruno.OS.Resource.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandartError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(long timestamp, Integer error, String message) {
		super(timestamp, error, message);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldname, String message) {
		this.errors.add(new FieldMessage(fieldname,message));
	}
}
