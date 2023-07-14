package com.example.storageservice.api.operations.itemStorage.importItem;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImportItemStorageRequest {
    private UUID id;
    private int quantity;

}
