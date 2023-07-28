package com.example.storageservice.api.api.operations.itemStorage.getByItemId;

import com.example.storageservice.api.api.operations.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetByItemIdRequest implements OperationRequest {
    private UUID itemId;

}
