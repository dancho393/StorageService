package com.example.storageservice.api.operations.itemStorage.get;

import org.springframework.stereotype.Service;

@Service
public interface GetItemStorageService {
    public GetItemStorageResponse getItem(GetItemStorageRequest storageItem);
}
