package com.example.storageservice.api.api.operations.shipment.take;


import com.example.storageservice.api.api.operations.base.Operation;
import com.example.storageservice.api.api.operations.shipment.forpurchase.ShipmentForPurchaseRequest;
import com.example.storageservice.api.api.operations.shipment.forpurchase.ShipmentForPurchaseResponse;

public interface TakeShipmentOperation extends Operation<TakeShipmentResponse,TakeShipmentRequest> {
    public TakeShipmentResponse operationProcess (TakeShipmentRequest request);

}
