package com.example.storageservice.api.api.operations.itemStorage.exportItem;


import com.example.storageservice.api.api.operations.base.Operation;

public interface ExportItemStorageService extends Operation<ExportItemStorageResponse,ExportItemStorageRequest> {
    public ExportItemStorageResponse operationProcess(ExportItemStorageRequest item);
}