package com.rocker.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<CustomError> customerExceptionHandler(CustomerException ce,WebRequest req){
		CustomError err = new CustomError();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomError> exceptionHandler(Exception e,WebRequest req){
		CustomError err = new CustomError();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}