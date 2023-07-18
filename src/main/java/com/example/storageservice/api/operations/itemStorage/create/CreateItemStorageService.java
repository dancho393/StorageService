package com.example.storageservice.api.operations.itemStorage.create;

import com.example.storageservice.api.operations.base.Operation;
import org.springframework.stereotype.Service;

@Service
public interface CreateItemStorageService extends Operation<CreateItemStorageResponse,CreateItemStorageRequest> {
    public CreateItemStorageResponse operationProcess(CreateItemStorageRequest itemStorage);
}
