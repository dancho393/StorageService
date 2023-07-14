package com.example.storageservice.api.operations.itemStorage.importItem;

import org.springframework.stereotype.Service;

@Service
public interface ImportItemStorageService {
    public ImportItemStorageReponse importItem(ImportItemStorageRequest item);
}
