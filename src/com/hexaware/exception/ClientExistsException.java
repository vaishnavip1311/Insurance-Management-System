package com.hexaware.exception;

public class ClientExistsException extends Exception{

	public ClientExistsException() {
		super();
	}
	
	public ClientExistsException(String message) {
        super(message);
    }

	@Override
	public String toString() {
		return "Client Already Exists";
	}
	
}
