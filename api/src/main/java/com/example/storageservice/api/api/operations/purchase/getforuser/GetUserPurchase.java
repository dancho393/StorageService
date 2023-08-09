package com.example.storageservice.api.api.operations.purchase.getforuser;

import lombok.*;

import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Setter
@Builder
@NoArgsConstructor
public class GetUserPurchase {
    private UUID id;
    private Boolean successful;
    private Timestamp purchaseDate;
    private Map<UUID,Integer> items;
    private Float totalPrice;
    private UUID userId;
}
