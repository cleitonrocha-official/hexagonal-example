package br.com.demo.core.errors.exceptions;

import static br.com.demo.core.errors.messages.AddressErrorMessages.NOT_FOUND_REGISTER_TO_UPDATE;

import br.com.demo.core.errors.exceptions.base.BaseBussinessException;

public class AddressException extends BaseBussinessException {

	private static final long serialVersionUID = 1L;
	
	private AddressException(String message) {
		super(message);
	}
	
	public static AddressException notFoundRegisterToChangerValues() {
		return new AddressException(NOT_FOUND_REGISTER_TO_UPDATE);
	}

}
