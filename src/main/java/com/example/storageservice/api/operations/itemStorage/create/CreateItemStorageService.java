package com.example.storageservice.api.operations.itemStorage.create;

import org.springframework.stereotype.Service;

@Service
public interface CreateItemStorageService {
    public CreateItemStorageResponse createItemStorage(CreateItemStorageRequest itemStorage);
}
