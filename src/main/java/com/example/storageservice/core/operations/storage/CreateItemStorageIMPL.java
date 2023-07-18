package com.example.storageservice.core.operations.storage;

import com.example.storageservice.api.operations.itemStorage.create.CreateItemStorageRequest;
import com.example.storageservice.api.operations.itemStorage.create.CreateItemStorageResponse;
import com.example.storageservice.api.operations.itemStorage.create.CreateItemStorageService;
import com.example.storageservice.persistence.entities.ItemStorage;
import com.example.storageservice.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateItemStorageIMPL implements CreateItemStorageService {
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public CreateItemStorageResponse operationProcess(CreateItemStorageRequest itemStorage) {
        ItemStorage itemStorageEntity = ItemStorage.builder()
                .itemId(itemStorage.getItemId())
                .price(itemStorage.getPrice())
                .quantity(itemStorage.getQuantity())
                .build();

        itemStorageRepository.save(itemStorageEntity);

        return CreateItemStorageResponse.builder()
                .id(itemStorageEntity.getId())
                .itemId(itemStorageEntity.getItemId())
                .price(itemStorageEntity.getPrice())
                .quantity(itemStorageEntity.getQuantity())
                .build();
    }
}
