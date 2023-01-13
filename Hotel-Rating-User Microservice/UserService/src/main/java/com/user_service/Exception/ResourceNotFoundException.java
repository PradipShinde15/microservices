package com.user_service.Exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundException() {
		super("Resource not found on server !!");
		// TODO Auto-generated constructor stub
	}
	
	

}
