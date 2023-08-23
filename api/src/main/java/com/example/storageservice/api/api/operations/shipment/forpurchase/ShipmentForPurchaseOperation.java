package com.example.storageservice.api.api.operations.shipment.forpurchase;

import com.example.storageservice.api.api.operations.base.Operation;

public interface ShipmentForPurchaseOperation extends Operation<ShipmentForPurchaseResponse,ShipmentForPurchaseRequest> {
    public ShipmentForPurchaseResponse operationProcess (ShipmentForPurchaseRequest request);
}
