package com.example.storageservice.api.api.operations.shipment.forpurchase;

import com.example.storageservice.api.api.operations.base.OperationResponse;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class ShipmentForPurchaseResponse implements OperationResponse {
    private List shipments;
}
