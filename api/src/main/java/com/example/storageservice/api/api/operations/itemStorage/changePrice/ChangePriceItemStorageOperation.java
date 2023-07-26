package com.example.storageservice.api.api.operations.itemStorage.changePrice;


import com.example.storageservice.api.api.operations.base.Operation;

public interface ChangePriceItemStorageOperation extends Operation<ChangePriceItemStorageResponse, ChangePriceItemStorageRequest> {
    public ChangePriceItemStorageResponse operationProcess(ChangePriceItemStorageRequest newPrice);
}
