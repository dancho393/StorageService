package com.example.storageservice.api.api.operations.shipment.arive;

import com.example.storageservice.api.api.operations.base.Operation;

public interface ShipmentArrivalOperation extends Operation<ShipmentArrivalResponse,ShipmentArrivalRequest> {
    public ShipmentArrivalResponse operationProcess (ShipmentArrivalRequest request);
}
