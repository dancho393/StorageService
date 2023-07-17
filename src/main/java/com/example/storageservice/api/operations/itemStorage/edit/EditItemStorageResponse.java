package com.example.storageservice.api.operations.itemStorage.edit;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditItemStorageResponse {
    private UUID id;
    private UUID itemId;
    private int quantity;
    private Float price;
}
