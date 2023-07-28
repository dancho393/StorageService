package com.example.storageservice.api.api.operations.itemStorage.getByItemId;

import com.example.storageservice.api.api.operations.base.Operation;

public interface GetByItemIdOperation extends Operation<GetByItemResponse,GetByItemIdRequest> {
    public GetByItemResponse operationProcess(GetByItemIdRequest itemId);
}
