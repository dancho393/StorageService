package com.example.storageservice.bussiness.operations.storage;

import com.example.storageservice.api.exceptions.ResourceNotFoundException;
import com.example.storageservice.api.operations.itemStorage.get.GetItemStorageRequest;
import com.example.storageservice.api.operations.itemStorage.get.GetItemStorageResponse;
import com.example.storageservice.api.operations.itemStorage.get.GetItemStorageService;
import com.example.storageservice.data.entities.ItemStorage;
import com.example.storageservice.data.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetItemStorageIMPL implements GetItemStorageService {
    private final ItemStorageRepository itemStorageRepository;

    @Override
    public GetItemStorageResponse getItem(GetItemStorageRequest storageItem) {
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
