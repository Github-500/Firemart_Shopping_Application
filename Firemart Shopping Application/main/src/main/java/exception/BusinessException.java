package com.application.exception;

@SuppressWarnings("serial")
public class BusinessException extends Exception {

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

}
