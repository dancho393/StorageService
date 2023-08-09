package com.example.storageservice.api.api.operations.purchase.getforuser;

import com.example.storageservice.api.api.operations.base.Operation;

public interface GetPurchaseForUserOperation extends Operation<GetPurchaseForUserResponse,GetPurchaseForUserRequest> {
    public GetPurchaseForUserResponse operationProcess(GetPurchaseForUserRequest request);
}
