package br.com.demo.adapter.inbound.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Not found register to changer")
public class BadRequestNotFoundRegisterToChangeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BadRequestNotFoundRegisterToChangeException() {
		super("Not found register to changes");
	}

}
