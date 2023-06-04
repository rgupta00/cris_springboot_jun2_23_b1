package com.productapp.util;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.productapp.exceptions.ProductNotFoundException;

//@RestControllerAdvice
public class ProductAppExceptionHandler {

	//------handle 404
	//@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorInfo> handle404(ProductNotFoundException ex){
		
		return null;
	}
	
	//@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> handle500(Exception ex){
		
		return null;
	}
}
