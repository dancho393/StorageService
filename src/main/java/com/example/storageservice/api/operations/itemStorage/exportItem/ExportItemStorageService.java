package com.example.storageservice.api.operations.itemStorage.exportItem;

import com.example.storageservice.api.operations.base.Operation;
import org.springframework.stereotype.Service;

@Service
public interface ExportItemStorageService extends Operation<ExportItemStorageResponse,ExportItemStorageRequest> {
    public ExportItemStorageResponse operationProcess(ExportItemStorageRequest item);
}
