package com.example.storageservice.rest.exceptions;

public class QuantityBelowZeroException extends RuntimeException{
    public QuantityBelowZeroException(String message){
        super(message);
    }
}
