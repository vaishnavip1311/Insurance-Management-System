package com.hexaware.exception;

public class PolicyNotFoundException extends Exception{
	
	public PolicyNotFoundException() {
		super();
	}

	public PolicyNotFoundException(String message) {
        super(message);
    }

	@Override
	public String toString() {
		return "Policy Not Found";
	}
	

}
