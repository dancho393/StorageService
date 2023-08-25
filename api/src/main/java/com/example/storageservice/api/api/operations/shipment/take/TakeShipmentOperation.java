package com.example.storageservice.api.api.operations.shipment.take;


import com.example.storageservice.api.api.operations.base.Operation;

public interface TakeShipmentOperation extends Operation<TakeShipmentResponse,TakeShipmentRequest> {
    public TakeShipmentResponse operationProcess (TakeShipmentRequest request);

}
