package com.example.storageservice.api.operations.itemStorage.importItem;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImportItemStorageReponse {
    private UUID id;
    private UUID itemId;
    private int quantity;
    private Float price;
}
