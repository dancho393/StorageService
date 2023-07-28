package com.example.storageservice.api.api.operations.itemStorage.changeQuantity;

import com.example.storageservice.api.api.operations.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeQuantityRequest implements OperationRequest {
    private UUID id;
    private int quantity;
}
