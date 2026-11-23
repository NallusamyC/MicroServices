package com.wipro.employee.exception;

public class EmployeeIdNotFoundException extends RuntimeException{

	public EmployeeIdNotFoundException(String message)
	{
		super("Exception not found with ID : "+ message);
	}
	private static final long serialVersionUID = -6897327068603421614L;
	@Override
	public String toString()
	{
		return "EmployeeId is not Found";
	}

}
