package com.smartdude.entity.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Error {

	@ApiModelProperty(notes = "Http Status Code", required = true)
	private Integer status;

	@ApiModelProperty(notes = "Http Status code Description", required = true)
	private HttpStatus httpStatus;

	@ApiModelProperty(notes = "Date and Time of the error occured", required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

	@ApiModelProperty(notes = "Message about the error that occured", required = true)
	private String message;

	@ApiModelProperty(notes = "Debug message for the developer regarding the error", required = true)
	private String debugMessage;

	@ApiModelProperty(notes = "Error code for Identification", required = true)
	private String errorCode;

}
