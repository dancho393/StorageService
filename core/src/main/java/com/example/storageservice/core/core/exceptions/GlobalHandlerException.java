package com.example.storageservice.core.core.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
    @ExceptionHandler(QuantityBelowZeroException.class)
    public ResponseEntity QuantityBelowZeroException(ResourceNotFoundException exception){
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(exception.getMessage());
    }
}
