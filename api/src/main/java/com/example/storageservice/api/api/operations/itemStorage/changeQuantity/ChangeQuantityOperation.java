package com.example.storageservice.api.api.operations.itemStorage.changeQuantity;

import com.example.storageservice.api.api.operations.base.Operation;

public interface ChangeQuantityOperation extends Operation<ChangeQuantityResponse,ChangeQuantityRequest> {
    ChangeQuantityResponse operationProcess(ChangeQuantityRequest itemStorage);
}
