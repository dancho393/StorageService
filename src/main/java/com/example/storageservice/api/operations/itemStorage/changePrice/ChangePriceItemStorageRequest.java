package com.example.storageservice.api.operations.itemStorage.changePrice;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangePriceItemStorageRequest {
    private UUID id;
    private Float newPrice;
}
