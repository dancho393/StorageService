package com.example.storageservice.api.api.operations.itemStorage.importItem;


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
public class ImportItemStorageRequest implements OperationRequest {
    @NotBlank
    private UUID id;
    @Min(value = 0,message = "Quantity must be greater or equal to zero")
    private int quantity;

}
