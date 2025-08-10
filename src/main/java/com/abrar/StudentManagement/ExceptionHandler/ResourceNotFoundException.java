package com.abrar.StudentManagement.ExceptionHandler;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
