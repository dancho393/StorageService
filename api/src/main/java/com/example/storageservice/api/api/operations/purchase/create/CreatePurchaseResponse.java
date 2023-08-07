package com.example.storageservice.api.api.operations.purchase.create;

import com.example.storageservice.api.api.operations.base.OperationResponse;
import lombok.*;

import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreatePurchaseResponse implements OperationResponse {

    private UUID id;

    private Boolean successful;

    private Timestamp purchaseDate;

    private Map<UUID,Integer> items;

    private Float totalPrice;

    private UUID userId;
}
