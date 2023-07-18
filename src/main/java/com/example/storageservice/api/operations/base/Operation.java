package com.example.storageservice.api.operations.base;

public interface Operation  <O extends OperationResponse,I extends OperationRequest>{
    public O operationProcess (I input);
    


}