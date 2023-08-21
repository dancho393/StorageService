package com.example.storageservice.api.api.operations.purchase.create;

import com.example.storageservice.api.api.operations.base.OperationRequest;
import lombok.*;

import java.util.Map;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreatePurchaseRequest implements OperationRequest {
    private Map<UUID,Integer> items;
    private Float totalPrice;
    private UUID userId;
    private Float userBalance;
    private int discountPoints;
}
