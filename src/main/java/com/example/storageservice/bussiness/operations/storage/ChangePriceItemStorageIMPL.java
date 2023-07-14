package com.example.storageservice.bussiness.operations.storage;

import com.example.storageservice.api.exceptions.ResourceNotFoundException;
import com.example.storageservice.api.operations.itemStorage.changePrice.ChangePriceItemStorageRequest;
import com.example.storageservice.api.operations.itemStorage.changePrice.ChangePriceItemStorageResponse;
import com.example.storageservice.api.operations.itemStorage.changePrice.ChangePriceItemStorageService;
import com.example.storageservice.data.entities.ItemStorage;
import com.example.storageservice.data.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangePriceItemStorageIMPL implements ChangePriceItemStorageService {
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public ChangePriceItemStorageResponse changePrice(ChangePriceItemStorageRequest newPrice) {
        ItemStorage itemStorageEntity = itemStorageRepository.findById(newPrice.getId())
                .orElseThrow(()->new ResourceNotFoundException("ItemStorage Not Found"));
        itemStorageEntity.setPrice(newPrice.getNewPrice());
        itemStorageRepository.save(itemStorageEntity);
        return ChangePriceItemStorageResponse.builder()
                .id(itemStorageEntity.getId())
                .itemId(itemStorageEntity.getItemId())
                .price(itemStorageEntity.getPrice())
                .quantity(itemStorageEntity.getQuantity())
                .build();
    }
}