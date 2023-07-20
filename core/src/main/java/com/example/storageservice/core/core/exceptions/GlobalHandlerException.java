//package com.example.storageservice.core.core.exceptions;
//
//
//
//@ControllerAdvice
//public class GlobalHandlerException {
//
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException exception){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
//    }
//    @ExceptionHandler(QuantityBelowZeroException.class)
//    public ResponseEntity QuantityBelowZeroException(ResourceNotFoundException exception){
//        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(exception.getMessage());
//    }
//}
