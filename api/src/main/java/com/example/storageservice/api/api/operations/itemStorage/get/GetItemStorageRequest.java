package com.example.storageservice.api.api.operations.itemStorage.get;



import com.example.storageservice.api.api.operations.base.OperationRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetItemStorageRequest implements OperationRequest {
    @NotBlank
    private UUID id;
}
