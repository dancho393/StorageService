package com.example.storageservice.core.core.operations.storage;

import com.example.storageservice.api.api.operations.itemStorage.exportItem.ExportItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.exportItem.ExportItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.exportItem.ExportItemStorageResponse;
import com.example.storageservice.core.core.exceptions.QuantityBelowZeroException;
import com.example.storageservice.core.core.exceptions.ResourceNotFoundException;
import com.example.storageservice.persistence.persistence.entities.ItemStorage;
import com.example.storageservice.persistence.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExportItemStorageIMPL implements ExportItemStorageOperation {
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
