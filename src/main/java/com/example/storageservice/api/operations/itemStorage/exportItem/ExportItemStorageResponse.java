package com.example.storageservice.api.operations.itemStorage.exportItem;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportItemStorageResponse {
    private UUID id;
    private UUID itemId;
    private int quantity;
    private Float price;
}
