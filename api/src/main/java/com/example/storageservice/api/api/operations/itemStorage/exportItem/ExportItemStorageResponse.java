package com.example.storageservice.api.api.operations.itemStorage.exportItem;


import com.example.storageservice.api.api.operations.base.OperationResponse;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportItemStorageResponse implements OperationResponse {
    private UUID id;
    private UUID itemId;
    private int quantity;
    private Float price;
}
