package com.cpfanalyzer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {
	
	private  String type;
	private  String message;
	
	 public HandlerException() {
		super();
	}

	public HandlerException(String type, String message) {
		super();
		this.type = type;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	 public HandlerException InvalidCpfException() {
		String type = "InvalidCpfException";
		String message = "CPF is not valid";
		HandlerException exception = new HandlerException(type, message);
		return exception;
	}
	public HandlerException ExistsCpfException() {
		String type = "ExistsCpfException";
		String message = "CPF already exists";
		HandlerException exception = new HandlerException(type, message);
		return exception;
	}
	
	
	public HandlerException NotFoundCpfException() {
		String type = "NotFoundCpfException";
		String message = "CPF not found";
		HandlerException exception = new HandlerException(type, message);
		return exception;
	}
	
	@ExceptionHandler
	public HandlerException handleException(HttpStatusCode httpstatus) {
		if (httpstatus == HttpStatus.BAD_REQUEST) {
			return InvalidCpfException();
		}
		else if (httpstatus == HttpStatus.NOT_FOUND) {
			return NotFoundCpfException();
		}
		else {
			return ExistsCpfException();
		}
	}
}
