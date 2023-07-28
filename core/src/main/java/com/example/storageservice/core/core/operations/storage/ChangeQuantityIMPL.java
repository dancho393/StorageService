package com.example.storageservice.core.core.operations.storage;

import com.example.storageservice.api.api.operations.itemStorage.changeQuantity.ChangeQuantityOperation;
import com.example.storageservice.api.api.operations.itemStorage.changeQuantity.ChangeQuantityRequest;
import com.example.storageservice.api.api.operations.itemStorage.changeQuantity.ChangeQuantityResponse;
import com.example.storageservice.core.core.exceptions.ResourceNotFoundException;
import com.example.storageservice.persistence.persistence.entities.ItemStorage;
import com.example.storageservice.persistence.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeQuantityIMPL implements ChangeQuantityOperation {
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public ChangeQuantityResponse operationProcess(ChangeQuantityRequest itemStorage) {
       ItemStorage itemStorageEntity = itemStorageRepository.findById(itemStorage.getId())
                .orElseThrow(()-> new ResourceNotFoundException("ItemStorage Not Found"));
       itemStorageEntity.setQuantity(itemStorageEntity.getQuantity()+itemStorage.getQuantity());
       itemStorageRepository.save(itemStorageEntity);
        return ChangeQuantityResponse.builder()
                .id(itemStorageEntity.getId())
                .quantity(itemStorageEntity.getQuantity())
                .price(itemStorageEntity.getPrice())
                .build();
    }
}
