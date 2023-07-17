package com.example.storageservice.api.operations.itemStorage.edit;

import org.springframework.stereotype.Service;

@Service
public interface EditItemStorageService {
    public EditItemStorageResponse editItemStorage(EditItemStorageRequest itemStorage);
}
