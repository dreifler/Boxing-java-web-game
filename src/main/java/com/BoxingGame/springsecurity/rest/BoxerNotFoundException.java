package com.BoxingGame.springsecurity.rest;

public class BoxerNotFoundException extends RuntimeException{

	public BoxerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BoxerNotFoundException(String message) {
		super(message);
	}

	public BoxerNotFoundException(Throwable cause) {
		super(cause);
	}
		
}
