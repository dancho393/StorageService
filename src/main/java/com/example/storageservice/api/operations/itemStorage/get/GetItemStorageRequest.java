package com.example.storageservice.api.operations.itemStorage.get;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetItemStorageRequest {
private UUID id;
}
