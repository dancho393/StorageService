package com.example.storageservice.core.core.operations.storage;

import com.example.storageservice.api.api.operations.itemStorage.getByItemId.GetByItemIdOperation;
import com.example.storageservice.api.api.operations.itemStorage.getByItemId.GetByItemIdRequest;
import com.example.storageservice.api.api.operations.itemStorage.getByItemId.GetByItemResponse;
import com.example.storageservice.persistence.persistence.entities.ItemStorage;
import com.example.storageservice.persistence.persistence.repositories.ItemStorageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class GetByItemIdIMPL implements GetByItemIdOperation {
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public GetByItemResponse operationProcess(GetByItemIdRequest itemId) {

        ItemStorage itemStorageEntity = itemStorageRepository.findByItemId(itemId.getItemId())
                .orElse(ItemStorage
                        .builder()
                        .price(0.0f)
                        .quantity(0)
                        .build());

        return GetByItemResponse.builder()
                .price(itemStorageEntity.getPrice())
                .quantity(itemStorageEntity.getQuantity())
                .build();
    }
}
