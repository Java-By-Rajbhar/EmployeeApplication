package com.employee.exception;

public class EmployeeResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EmployeeResourceNotFoundException(String message)
	{
		super(message);
	}

}
