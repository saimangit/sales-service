package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.model.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {
	
  
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> gobalExceptionHandler(Exception ex, WebRequest request){
		ErrorDetails error= 
				new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
