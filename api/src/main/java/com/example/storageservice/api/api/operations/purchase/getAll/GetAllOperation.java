package com.example.storageservice.api.api.operations.purchase.getAll;

import com.example.storageservice.api.api.operations.base.Operation;
import com.example.storageservice.api.api.operations.base.OperationRequest;
import com.example.storageservice.api.api.operations.base.OperationResponse;

public interface GetAllOperation extends Operation<GetAllResponse,GetAllRequest> {
    public GetAllResponse operationProcess(GetAllRequest request);
}
