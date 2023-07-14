package com.example.storageservice.api.operations.itemStorage.create;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemStorageRequest {

    private UUID itemId;
    private int quantity;
    private Float price;
}
