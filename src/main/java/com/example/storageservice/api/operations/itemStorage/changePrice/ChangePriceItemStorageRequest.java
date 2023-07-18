package com.example.storageservice.api.operations.itemStorage.changePrice;

import com.example.storageservice.api.operations.base.OperationRequest;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangePriceItemStorageRequest implements OperationRequest {
    private UUID id;
    @Min(value = 0,message = "The number must be greater or equal to zero")
    private Float newPrice;
}
