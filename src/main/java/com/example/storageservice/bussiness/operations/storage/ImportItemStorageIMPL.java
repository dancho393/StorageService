package com.example.storageservice.bussiness.operations.storage;

import com.example.storageservice.api.exceptions.ResourceNotFoundException;
import com.example.storageservice.api.operations.itemStorage.importItem.ImportItemStorageReponse;
import com.example.storageservice.api.operations.itemStorage.importItem.ImportItemStorageRequest;
import com.example.storageservice.api.operations.itemStorage.importItem.ImportItemStorageService;
import com.example.storageservice.data.entities.ItemStorage;
import com.example.storageservice.data.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImportItemStorageIMPL implements ImportItemStorageService {
    private final ItemStorageRepository itemStorageRepository;

    @Override
    public ImportItemStorageReponse importItem(ImportItemStorageRequest item) {
        ItemStorage itemStorageEntity=itemStorageRepository.findById(item.getId())
                .orElseThrow(()->new ResourceNotFoundException("ItemStorage Not Found"));
        //Future Exception
        itemStorageEntity.setQuantity(item.getQuantity()+itemStorageEntity.getQuantity());

        itemStorageRepository.save(itemStorageEntity);
        return ImportItemStorageReponse.builder()
                .id(itemStorageEntity.getId())
                .itemId(itemStorageEntity.getItemId())
                .quantity(itemStorageEntity.getQuantity())
                .price(itemStorageEntity.getPrice())
                .build();
    }
}
