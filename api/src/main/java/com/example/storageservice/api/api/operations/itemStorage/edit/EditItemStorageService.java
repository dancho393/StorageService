package com.example.storageservice.api.api.operations.itemStorage.edit;


import com.example.storageservice.api.api.operations.base.Operation;

public interface EditItemStorageService extends Operation<EditItemStorageResponse, EditItemStorageRequest> {
     EditItemStorageResponse operationProcess(EditItemStorageRequest itemStorage);
}
