package com.example.storageservice.api.operations.itemStorage.importItem;

import com.example.storageservice.api.operations.base.Operation;
import org.springframework.stereotype.Service;

@Service
public interface ImportItemStorageService extends Operation<ImportItemStorageResponse,ImportItemStorageRequest> {
    public ImportItemStorageResponse operationProcess(ImportItemStorageRequest item);
}
