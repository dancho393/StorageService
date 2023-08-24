package com.example.storageservice.api.api.operations.itemStorage.create;


import com.example.storageservice.api.api.operations.base.OperationRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemStorageRequest implements OperationRequest {

    @NotBlank
    private UUID itemId;
    @Min(value = 0,message = "Quantity must be greater or equal to zero")
    private Integer quantity;
    @Min(value = 0,message = "Price must be greater or equal to zero")
    private Float price;
}
