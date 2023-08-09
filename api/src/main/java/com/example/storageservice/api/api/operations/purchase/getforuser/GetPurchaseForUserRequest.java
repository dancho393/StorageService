package com.example.storageservice.api.api.operations.purchase.getforuser;

import com.example.storageservice.api.api.operations.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Setter
@Builder
@NoArgsConstructor
public class GetPurchaseForUserRequest implements OperationRequest {
    private UUID userId;
}
