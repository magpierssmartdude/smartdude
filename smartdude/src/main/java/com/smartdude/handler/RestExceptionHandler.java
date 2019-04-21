package com.smartdude.handler;

import java.time.LocalDateTime;
import com.smartdude.entity.exception.Error;
import com.smartdude.entity.exception.PasswordEncryptionException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.smartdude.entity.exception.EntityNotFoundException;
import com.smartdude.entity.exception.EntitySaveException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(EntitySaveException.class)
	public ResponseEntity<Object> handleEntitySave(EntitySaveException ex) {
		Error apiError = new Error();
		apiError.setTimestamp(LocalDateTime.now());
		apiError.setStatus(500);
		apiError.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		apiError.setMessage(ex.getMessage());
		apiError.setErrorCode("ENS");
		apiError.setDebugMessage(ex.toString());
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(PasswordEncryptionException.class)
	public ResponseEntity<Object> handlePasswordEncryption(PasswordEncryptionException ex) {
		Error apiError = new Error();
		apiError.setTimestamp(LocalDateTime.now());
		apiError.setStatus(500);
		apiError.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		apiError.setMessage(ex.getMessage());
		apiError.setErrorCode("NO_PASS_ENCR");
		apiError.setDebugMessage(ex.toString());
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
		Error apiError = new Error();
		apiError.setTimestamp(LocalDateTime.now());
		apiError.setStatus(404);
		apiError.setHttpStatus(HttpStatus.NOT_FOUND);
		apiError.setMessage(ex.getMessage());
		apiError.setErrorCode("ENF");
		apiError.setDebugMessage(ex.toString());
		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(Error apiError) {
		return new ResponseEntity<>(apiError, apiError.getHttpStatus());
	}
}
