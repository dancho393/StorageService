package com.example.storageservice.api.operations.itemStorage.changePrice;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangePriceItemStorageResponse {
    private UUID id;
    private UUID itemId;
    private int quantity;
    private Float price;
}
