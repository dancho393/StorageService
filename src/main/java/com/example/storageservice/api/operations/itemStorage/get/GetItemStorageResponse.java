package com.example.storageservice.api.operations.itemStorage.get;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetItemStorageResponse {
    private UUID id;
    private UUID itemId;
    private int quantity;
    private Float price;
}
