package com.example.storageservice.api.operations.itemStorage.get;

import com.example.storageservice.api.operations.base.Operation;
import org.springframework.stereotype.Service;

@Service
public interface GetItemStorageService extends Operation<GetItemStorageResponse,GetItemStorageRequest> {
    public GetItemStorageResponse operationProcess(GetItemStorageRequest storageItem);
}
