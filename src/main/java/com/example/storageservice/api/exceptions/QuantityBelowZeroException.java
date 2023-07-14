package com.example.storageservice.api.exceptions;

public class QuantityBelowZeroException extends RuntimeException{
    public QuantityBelowZeroException(String message){
        super(message);
    }
}
