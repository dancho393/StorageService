package com.example.storageservice.restexport;

import com.example.storageservice.api.api.operations.itemStorage.get.GetItemStorageResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Content-Type: application/json"})
public interface StorageServiceRestClient {
    @RequestLine("GET /itemStorages/{id}")
    GetItemStorageResponse getItemStorage(@Param String id);
}
