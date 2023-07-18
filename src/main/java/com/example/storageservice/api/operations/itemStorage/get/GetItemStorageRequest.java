package com.example.storageservice.api.operations.itemStorage.get;


import com.example.storageservice.api.operations.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetItemStorageRequest implements OperationRequest {
private UUID id;
}
