package com.example.bankkata.rest.exception;


public class InvalidOperationException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidOperationException(String opertation) {
		super(String.format("operation %s refused, The amount must not be null.", opertation));
	}

}
