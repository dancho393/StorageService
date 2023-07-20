package com.example.storageservice.api.api.operations.itemStorage.get;


import com.example.storageservice.api.api.operations.base.Operation;

public interface GetItemStorageService extends Operation<GetItemStorageResponse,GetItemStorageRequest> {
    public GetItemStorageResponse operationProcess(GetItemStorageRequest storageItem);
}
