package com.example.storageservice.api.api.operations.itemStorage.edit;


import com.example.storageservice.api.api.operations.base.Operation;

public interface EditItemStorageOperation extends Operation<EditItemStorageResponse, EditItemStorageRequest> {
     EditItemStorageResponse operationProcess(EditItemStorageRequest itemStorage);
}
