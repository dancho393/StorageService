package com.example.storageservice.core.core.operations.storage;


import com.example.storageservice.api.api.operations.itemStorage.create.CreateItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.create.CreateItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.create.CreateItemStorageResponse;
import com.example.storageservice.core.core.exceptions.ResourceNotFoundException;
import com.example.storageservice.persistence.persistence.entities.ItemStorage;
import com.example.storageservice.persistence.persistence.repositories.ItemStorageRepository;
import com.example.zoostore.restexport.ZooStoreRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateItemStorageIMPL implements CreateItemStorageOperation {
    private final ItemStorageRepository itemStorageRepository;
    private final ZooStoreRestClient zooStoreRestClient;

    @Override
    public CreateItemStorageResponse operationProcess(CreateItemStorageRequest itemStorage) {

        try {
            zooStoreRestClient.getItemById(itemStorage.getItemId().toString());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Item Not Found:"+e.getMessage());
        }


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




