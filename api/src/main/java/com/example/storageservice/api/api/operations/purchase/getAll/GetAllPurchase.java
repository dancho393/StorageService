package com.example.storageservice.api.api.operations.purchase.getAll;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetAllPurchase {
    private UUID id;

    private Boolean successful;

    private Timestamp purchaseDate;

    private Map<String,Integer> items;

    private Float totalPrice;

    private UUID userId;}
