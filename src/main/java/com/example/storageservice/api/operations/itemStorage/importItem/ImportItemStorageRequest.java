package com.example.storageservice.api.operations.itemStorage.importItem;

import com.example.storageservice.api.operations.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImportItemStorageRequest implements OperationRequest {
    private UUID id;
    private int quantity;

}
