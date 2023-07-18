package com.example.storageservice.core.operations.storage;

import com.example.storageservice.rest.exceptions.ResourceNotFoundException;
import com.example.storageservice.api.operations.itemStorage.get.GetItemStorageRequest;
import com.example.storageservice.api.operations.itemStorage.get.GetItemStorageResponse;
import com.example.storageservice.api.operations.itemStorage.get.GetItemStorageService;
import com.example.storageservice.persistence.entities.ItemStorage;
import com.example.storageservice.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetItemStorageIMPL implements GetItemStorageService {
    private final ItemStorageRepository itemStorageRepository;

    @Override
    public GetItemStorageResponse operationProcess(GetItemStorageRequest storageItem) {
        ItemStorage itemStorageEntity = itemStorageRepository.findById(storageItem.getId())
                .orElseThrow(()->new ResourceNotFoundException("ItemStorage Not Found"));

        return GetItemStorageResponse.builder()
                .id(itemStorageEntity.getId())
                .itemId(itemStorageEntity.getItemId())
                .price(itemStorageEntity.getPrice())
                .quantity(itemStorageEntity.getQuantity())
                .build();
    }
}
