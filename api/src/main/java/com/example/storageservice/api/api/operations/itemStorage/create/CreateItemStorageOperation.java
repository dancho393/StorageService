package com.example.storageservice.api.api.operations.itemStorage.create;


import com.example.storageservice.api.api.operations.base.Operation;

public interface CreateItemStorageOperation extends Operation<CreateItemStorageResponse,CreateItemStorageRequest> {
    public CreateItemStorageResponse operationProcess(CreateItemStorageRequest itemStorage);
}
