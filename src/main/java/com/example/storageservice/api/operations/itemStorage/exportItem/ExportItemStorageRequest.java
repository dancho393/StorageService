package com.example.storageservice.api.operations.itemStorage.exportItem;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportItemStorageRequest {
    private UUID id;
    private int quantity;
}
