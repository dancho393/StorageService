package com.example.storageservice.api.api.operations.shipment.take;

import com.example.storageservice.api.api.operations.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TakeShipmentRequest implements OperationRequest {
    private UUID shipmentId;
    private UUID userId;
}
