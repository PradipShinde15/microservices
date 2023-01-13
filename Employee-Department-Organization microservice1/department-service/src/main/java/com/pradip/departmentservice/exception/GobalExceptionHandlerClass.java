package com.pradip.departmentservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;



@RestControllerAdvice
public class GobalExceptionHandlerClass {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> HandleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
		
		ErrorDetails details=new ErrorDetails(
		   LocalDateTime.now(), ex.getMessage(), request.getDescription(false), "RESOURCE_NOT_FOUND");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleException( Exception ex, WebRequest request){
		
		ErrorDetails details=new ErrorDetails(
		   LocalDateTime.now(), ex.getMessage(), request.getDescription(false), "RESOURCE_NOT_FOUND");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
		
	}

}
