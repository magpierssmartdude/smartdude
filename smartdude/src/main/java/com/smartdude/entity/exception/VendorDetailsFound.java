package com.smartdude.entity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VendorDetailsFound extends Exception {
	/**
	 * Default serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public VendorDetailsFound(String message) {
	      super(message);
	   }
}
