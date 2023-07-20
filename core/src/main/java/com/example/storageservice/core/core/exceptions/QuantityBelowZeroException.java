package com.example.storageservice.core.core.exceptions;

public class QuantityBelowZeroException extends RuntimeException{
    public QuantityBelowZeroException(String message){
        super(message);
    }
}
