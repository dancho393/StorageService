package com.example.storageservice.api.api.operations.shipment.forpurchase;

import com.example.storageservice.api.api.operations.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShipmentForPurchaseRequest implements OperationRequest {
    private UUID purchaseId;

}
