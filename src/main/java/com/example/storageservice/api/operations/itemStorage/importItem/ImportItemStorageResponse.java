package com.example.storageservice.api.operations.itemStorage.importItem;

import com.example.storageservice.api.operations.base.OperationResponse;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImportItemStorageResponse implements OperationResponse {
    private UUID id;
    private UUID itemId;
    private int quantity;
    private Float price;

}
