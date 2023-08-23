package com.example.storageservice.api.api.operations.shipment.arive;

import com.example.storageservice.api.api.operations.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShipmentArrivalRequest implements OperationRequest {
    private UUID shipmentId;
}
