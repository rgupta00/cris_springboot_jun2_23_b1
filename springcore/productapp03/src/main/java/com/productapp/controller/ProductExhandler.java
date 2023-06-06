package com.productapp.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.productapp.dto.EorrorInfo;
import com.productapp.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class ProductExhandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<EorrorInfo> handle500(Exception ex) {
		EorrorInfo errorInfo=new EorrorInfo();
		errorInfo.setDateTime(LocalDateTime.now());
		errorInfo.setToContact("rgupta.mtech@gmail.com");
		errorInfo.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		errorInfo.setErrorMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<EorrorInfo> handle404(ProductNotFoundException ex) {
		EorrorInfo errorInfo=new EorrorInfo();
		errorInfo.setDateTime(LocalDateTime.now());
		errorInfo.setToContact("rgupta.mtech@gmail.com");
		errorInfo.setStatusCode(HttpStatus.NOT_FOUND.toString());
		errorInfo.setErrorMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
		
	}
	
	
	
}
