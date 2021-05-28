package br.com.demo.core.errors;

public class NotFoundRegisterToChangerValuesException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NotFoundRegisterToChangerValuesException() {
		super("Not found register to update");
	}

}
