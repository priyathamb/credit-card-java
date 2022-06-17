package com.card.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidCardNumberException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidCardNumberException(String message) {
		super(message);
	}
	
}
