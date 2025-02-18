package com.cg.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.exception.MovieNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(exception=MovieNotFoundException.class)
	public ResponseEntity<String> handle(Exception e){
		 return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
