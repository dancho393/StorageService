package com.example.storageservice.api.operations.itemStorage.exportItem;

import com.example.storageservice.api.operations.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportItemStorageRequest implements OperationRequest {
    private UUID id;
    private int quantity;
}
