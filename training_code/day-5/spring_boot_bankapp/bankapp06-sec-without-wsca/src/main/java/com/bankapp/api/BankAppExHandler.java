package com.bankapp.api;

import com.bankapp.dto.ErrorInfo;
import com.bankapp.exceptions.BankAccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class BankAppExHandler {

    //handle BankAccountNotFoundException
    @ExceptionHandler(BankAccountNotFoundException.class)
    public ResponseEntity<ErrorInfo> handleBankAccountNotFoundException(BankAccountNotFoundException ex){
        ErrorInfo errorInfo=ErrorInfo.builder()
                .message(ex.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.toString())
                .timestamp(LocalDateTime.now())
                .toContact("rgupta.mtech@gmail.com")
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorInfo> handle400(MethodArgumentNotValidException ex){

        String errorMessage= ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(x-> x.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErrorInfo errorInfo=ErrorInfo.builder()
                .message(errorMessage)
                .statusCode(HttpStatus.BAD_REQUEST.toString())
                .timestamp(LocalDateTime.now())
                .toContact("rgupta.mtech@gmail.com")
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
    }

    //handle 500
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorInfo> handle500(Exception ex){
//        ErrorInfo errorInfo=ErrorInfo.builder()
//                .message("Please try after some time")
//                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString())
//                .timestamp(LocalDateTime.now())
//                .toContact("rgupta.mtech@gmail.com")
//                .build();
//
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
//    }

    //handle 400
}
