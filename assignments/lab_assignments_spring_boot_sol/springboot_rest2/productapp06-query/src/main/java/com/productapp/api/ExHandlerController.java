package com.productapp.api;

import com.productapp.dto.ErrorInfo;
import com.productapp.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExHandlerController {

    //ex handler ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorInfo> handle404(ResourceNotFoundException ex){
        ErrorInfo errorInfo=ErrorInfo.builder()
                .errorMessage(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.NOT_FOUND.toString())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorInfo> handle400(MethodArgumentNotValidException ex){

        //SomeHow i want to extract all the error message and show back the client
        //EXPECTING U DO REACTIVE WITHOUT UNDERSTING JAVA 8 IS A FUN

        String errorMessage=ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(x->x.getDefaultMessage())
                .collect(Collectors.joining(" , "));


        ErrorInfo errorInfo=ErrorInfo.builder()
                .errorMessage(errorMessage)
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.BAD_REQUEST.toString())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
    }

    //ex handle
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorInfo> handle500(Exception ex){
//
//        ErrorInfo errorInfo=ErrorInfo.builder()
//                .errorMessage("please try after some time")
//                .timestamp(LocalDateTime.now())
//                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString())
//                .toContent("rgupta.mtech@gmail.com")
//                .build();
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
//    }
}
