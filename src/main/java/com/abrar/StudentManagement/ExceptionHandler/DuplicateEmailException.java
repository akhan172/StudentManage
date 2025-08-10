package com.abrar.StudentManagement.ExceptionHandler;

public class DuplicateEmailException extends RuntimeException{
	
	public DuplicateEmailException(String message){
		super(message);
	}

}
