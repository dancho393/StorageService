package com.example.storageservice.api.api.operations.purchase.getAll;

import com.example.storageservice.api.api.operations.base.OperationRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetAllRequest implements OperationRequest {
    private int page;
}
