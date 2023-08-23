package com.example.storageservice.api.api.operations.shipment.take;

import com.example.storageservice.api.api.operations.base.OperationResponse;
import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TakeShipmentResponse implements OperationResponse {
    private String shipmentStatus;
    private String takenTime;
    private Float refundedMoney=0.0f;
    private UUID userId;
}
