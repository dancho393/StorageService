package com.example.storageservice.api.api.operations.itemStorage.changePrice;


import com.example.storageservice.api.api.operations.base.OperationResponse;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangePriceItemStorageResponse implements OperationResponse {
    private UUID id;
    private UUID itemId;
    private int quantity;
    private Float price;
}
