package com.bruno.OS.Resource.exceptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bruno.OS.services.Exception.*;

@ControllerAdvice
public class ResourceExceptionHnadler implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFoundException(ObjectNotFoundException e ){
		StandartError error = new StandartError(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	
	@ExceptionHandler(DataIntegratyViolationException.class)
	public ResponseEntity<StandartError> dataIntegratyViolationException(DataIntegratyViolationException e ){
		StandartError error = new StandartError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandartError> objectNotFoundException(MethodArgumentNotValidException e ){
		ValidationError error = new ValidationError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),
				"Erro nas validações dos campos");
		
		for (FieldError x : e.getBindingResult().getFieldErrors() ) {
			error.addErrors(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	
	
	
	

	
}
