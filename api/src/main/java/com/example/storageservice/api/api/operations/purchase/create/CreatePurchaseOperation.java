package com.example.storageservice.api.api.operations.purchase.create;

import com.example.storageservice.api.api.operations.base.Operation;
import com.example.storageservice.api.api.operations.base.OperationResponse;

public interface CreatePurchaseOperation extends Operation<CreatePurchaseResponse,CreatePurchaseRequest> {
    public CreatePurchaseResponse operationProcess(CreatePurchaseRequest request);
}
