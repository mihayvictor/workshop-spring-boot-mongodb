package com.mihayvictor.workshopmongo.services.exception;

public class ObjectNotFondException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ObjectNotFondException(String msg) {
		super(msg);
	}
}
