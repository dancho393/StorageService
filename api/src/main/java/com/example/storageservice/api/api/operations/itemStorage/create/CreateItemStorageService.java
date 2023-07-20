package com.example.storageservice.api.api.operations.itemStorage.create;


import com.example.storageservice.api.api.operations.base.Operation;

public interface CreateItemStorageService extends Operation<CreateItemStorageResponse,CreateItemStorageRequest> {
    public CreateItemStorageResponse operationProcess(CreateItemStorageRequest itemStorage);
}
