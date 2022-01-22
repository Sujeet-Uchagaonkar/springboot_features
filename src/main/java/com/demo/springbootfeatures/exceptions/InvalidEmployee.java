package com.demo.springbootfeatures.exceptions;

public class InvalidEmployee extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidEmployee() {
		super();
	}

	public InvalidEmployee(String message) {
		super(message);
	}

}
