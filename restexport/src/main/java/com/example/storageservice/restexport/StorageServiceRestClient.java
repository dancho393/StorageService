package com.example.storageservice.restexport;

import com.example.storageservice.api.api.operations.itemStorage.get.GetItemStorageResponse;
import com.example.storageservice.api.api.operations.itemStorage.getByItemId.GetByItemResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Content-Type: application/json"})
public interface StorageServiceRestClient {
    @RequestLine("GET /itemStorages/{id}")
    GetItemStorageResponse getItemStorage(@Param String id);
    @RequestLine("GET /itemStorages/byItemId/{itemId}")
    GetByItemResponse getStorageById(@Param String itemId);
}
