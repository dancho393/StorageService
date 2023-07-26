package com.example.storageservice.core.core.operations.storage;

import com.example.storageservice.api.api.operations.itemStorage.importItem.ImportItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.importItem.ImportItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.importItem.ImportItemStorageResponse;
import com.example.storageservice.core.core.exceptions.ResourceNotFoundException;
import com.example.storageservice.persistence.persistence.entities.ItemStorage;
import com.example.storageservice.persistence.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ImportItemStorageIMPL implements ImportItemStorageOperation {
    private final ItemStorageRepository itemStorageRepository;

    @Override
    public ImportItemStorageResponse operationProcess(ImportItemStorageRequest item) {
        ItemStorage itemStorageEntity=itemStorageRepository.findById(item.getId())
                .orElseThrow(()->new ResourceNotFoundException("ItemStorage Not Found"));
        //Future Exception
        itemStorageEntity.setQuantity(item.getQuantity()+itemStorageEntity.getQuantity());

        itemStorageRepository.save(itemStorageEntity);
        return ImportItemStorageResponse.builder()
                .id(itemStorageEntity.getId())
                .itemId(itemStorageEntity.getItemId())
                .quantity(itemStorageEntity.getQuantity())
                .price(itemStorageEntity.getPrice())
                .build();
    }
}
