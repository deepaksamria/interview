package com.diatoz.college.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.diatoz.college.model.ErrorDetail;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
	
	
	@ExceptionHandler
	public ResponseEntity<?> validationErrorHandler(MethodArgumentNotValidException exception){
		ErrorDetail error=new ErrorDetail("Validation Error", exception.getBindingResult().getFieldError().getDefaultMessage());
		log.info("Error happed in data validation which is received from user");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<?> allExceptionHandler(Exception exception){
		ErrorDetail error=new ErrorDetail("Error occured", exception.getCause().toString());
		log.info("Error occured "+exception.getCause().toString());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
