package com.example.storageservice.api.operations.itemStorage.exportItem;

import org.springframework.stereotype.Service;

@Service
public interface ExportItemStorageService {
    public ExportItemStorageResponse exportItem(ExportItemStorageRequest item);
}
