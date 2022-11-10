package com.employeepayrolldb;

public class EmployeeCustomException extends Exception {
	public EmployeeCustomException(String Invalid_Input) {
		super(Invalid_Input);
	}

}
