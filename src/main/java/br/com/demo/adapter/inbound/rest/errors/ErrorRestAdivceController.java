package br.com.demo.adapter.inbound.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.demo.core.errors.exceptions.base.BaseBussinessException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ErrorRestAdivceController {

	@ExceptionHandler(BaseBussinessException.class)
	public ResponseEntity<ErroResponseJson> handler(BaseBussinessException exception) {

		log.error("BussinessException handler", exception);
		
		return ResponseEntity.badRequest().body(ErroResponseJson.from(HttpStatus.BAD_REQUEST, exception));

	}

}
