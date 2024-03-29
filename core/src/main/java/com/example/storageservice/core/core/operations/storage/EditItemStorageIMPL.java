package com.example.storageservice.core.core.operations.storage;

import com.example.storageservice.api.api.operations.itemStorage.edit.EditItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.edit.EditItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.edit.EditItemStorageResponse;
import com.example.storageservice.core.core.exceptions.ResourceNotFoundException;
import com.example.storageservice.persistence.persistence.entities.ItemStorage;
import com.example.storageservice.persistence.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditItemStorageIMPL implements EditItemStorageOperation {
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public EditItemStorageResponse operationProcess(EditItemStorageRequest itemStorage) {
        ItemStorage itemStorageEntity = itemStorageRepository.findById(itemStorage.getId())
                .orElseThrow(()->new ResourceNotFoundException("ItemStorage Not Found"));
        itemStorageEntity.setQuantity(itemStorage.getQuantity());
        itemStorageEntity.setItemId(itemStorage.getItemId());
        itemStorageEntity.setPrice(itemStorage.getPrice());

        return EditItemStorageResponse.builder()
                .id(itemStorageEntity.getId())
                .quantity(itemStorageEntity.getQuantity())
                .itemId(itemStorageEntity.getItemId())
                .price(itemStorage.getPrice())
                .build();
    }


}
