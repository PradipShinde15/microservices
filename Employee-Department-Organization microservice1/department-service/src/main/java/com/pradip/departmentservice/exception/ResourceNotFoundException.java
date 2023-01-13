package com.pradip.departmentservice.exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String resourceName;
	private final String fieldName;
	private final String fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s is not fount with %s: %s",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	

}
