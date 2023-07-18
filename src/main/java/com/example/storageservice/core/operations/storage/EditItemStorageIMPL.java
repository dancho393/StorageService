package com.example.storageservice.core.operations.storage;

import com.example.storageservice.rest.exceptions.ResourceNotFoundException;
import com.example.storageservice.api.operations.itemStorage.edit.EditItemStorageRequest;
import com.example.storageservice.api.operations.itemStorage.edit.EditItemStorageResponse;
import com.example.storageservice.api.operations.itemStorage.edit.EditItemStorageService;
import com.example.storageservice.persistence.entities.ItemStorage;
import com.example.storageservice.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditItemStorageIMPL implements EditItemStorageService {
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
