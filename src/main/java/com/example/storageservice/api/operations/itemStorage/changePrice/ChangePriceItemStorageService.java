package com.example.storageservice.api.operations.itemStorage.changePrice;

import com.example.storageservice.api.operations.base.Operation;
import org.springframework.stereotype.Service;

@Service
public interface ChangePriceItemStorageService extends Operation<ChangePriceItemStorageResponse, ChangePriceItemStorageRequest> {
    public ChangePriceItemStorageResponse operationProcess(ChangePriceItemStorageRequest newPrice);
}
