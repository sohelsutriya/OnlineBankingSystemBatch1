package com.cg.obs.util;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.obs.excetption.AccountNotFoundException;
import com.cg.obs.excetption.ExceptionResponse;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({ AccountNotFoundException.class })
	public final ResponseEntity<Object> handleUserNotFoundException(AccountNotFoundException ex, WebRequest req) {
		ExceptionResponse expResp = new ExceptionResponse(new Date(), ex.getMessage(), "Account Not found");
		return new ResponseEntity(expResp, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) {
		ExceptionResponse expResp = new ExceptionResponse(new Date(), ex.getMessage(), "Server down");
		return new ResponseEntity(expResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
