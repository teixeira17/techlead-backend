package com.techlead.biblioteca.services.exceptions;

public class DuplicateEntityException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DuplicateEntityException(String msg) {
		super(msg);
	}
}
