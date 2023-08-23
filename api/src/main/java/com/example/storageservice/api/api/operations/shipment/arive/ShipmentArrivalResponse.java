package com.example.storageservice.api.api.operations.shipment.arive;

import com.example.storageservice.api.api.operations.base.OperationResponse;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ShipmentArrivalResponse implements OperationResponse {
    private String status;
}
