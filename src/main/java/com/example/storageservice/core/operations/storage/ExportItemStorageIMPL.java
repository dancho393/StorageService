package com.example.storageservice.core.operations.storage;

import com.example.storageservice.rest.exceptions.QuantityBelowZeroException;
import com.example.storageservice.rest.exceptions.ResourceNotFoundException;
import com.example.storageservice.api.operations.itemStorage.exportItem.ExportItemStorageRequest;
import com.example.storageservice.api.operations.itemStorage.exportItem.ExportItemStorageResponse;
import com.example.storageservice.api.operations.itemStorage.exportItem.ExportItemStorageService;
import com.example.storageservice.persistence.entities.ItemStorage;
import com.example.storageservice.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExportItemStorageIMPL implements ExportItemStorageService {
    private final ItemStorageRepository itemStorageRepository;

    @Override
    public ExportItemStorageResponse operationProcess(ExportItemStorageRequest item) {
        ItemStorage itemStorageEntity=itemStorageRepository.findById(item.getId())
                        .orElseThrow(()->new ResourceNotFoundException("ItemStorage Not Found"));
        itemStorageEntity.setQuantity(itemStorageEntity.getQuantity()- item.getQuantity());
        if(itemStorageEntity.getQuantity()<0)
            throw new QuantityBelowZeroException("You dont have enought Quantity");
        //Here Check if you quantity gets below 0;
        itemStorageRepository.save(itemStorageEntity);

        return ExportItemStorageResponse.builder()
                .id(itemStorageEntity.getId())
                .itemId(itemStorageEntity.getItemId())
                .price(itemStorageEntity.getPrice())
                .quantity(itemStorageEntity.getQuantity())
                .build();
    }
}
