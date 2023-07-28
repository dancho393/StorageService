package com.example.storageservice.api.api.operations.itemStorage.changeQuantity;

import com.example.storageservice.api.api.operations.base.OperationResponse;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeQuantityResponse implements OperationResponse {
    private UUID id;
    private int quantity;
    private float price;
}
