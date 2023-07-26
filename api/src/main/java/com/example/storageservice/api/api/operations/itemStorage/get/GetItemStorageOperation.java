package com.example.storageservice.api.api.operations.itemStorage.get;


import com.example.storageservice.api.api.operations.base.Operation;

public interface GetItemStorageOperation extends Operation<GetItemStorageResponse,GetItemStorageRequest> {
    public GetItemStorageResponse operationProcess(GetItemStorageRequest storageItem);
}
