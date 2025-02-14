package com.devcaio.crudclientes.services.exceptions;

public class NotValidException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NotValidException() {
		super("Essa entrada não é valida");
	}

}
