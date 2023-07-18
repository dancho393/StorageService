package com.example.storageservice.api.operations.itemStorage.create;

import com.example.storageservice.api.operations.base.OperationRequest;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemStorageRequest implements OperationRequest {

    private UUID itemId;
    @Min(value = 0,message = "Quantity must be greater or equal to zero")
    private int quantity;
    @Min(value = 0,message = "Price must be greater or equal to zero")
    private Float price;
}
