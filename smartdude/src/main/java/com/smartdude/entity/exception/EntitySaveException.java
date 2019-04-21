package com.smartdude.entity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EntitySaveException extends Exception {
   /**
    * Default serialVersionUID.
    */
   private static final long serialVersionUID = 1L;

   public EntitySaveException(String message) {
      super(message);
   }
}
