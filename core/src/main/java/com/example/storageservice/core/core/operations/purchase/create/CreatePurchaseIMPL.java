package com.example.storageservice.core.core.operations.purchase.create;

import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseOperation;
import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseRequest;
import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseResponse;
import com.example.storageservice.persistence.persistence.entities.ItemStorage;
import com.example.storageservice.persistence.persistence.entities.Purchase;
import com.example.storageservice.persistence.persistence.repositories.ItemStorageRepository;
import com.example.storageservice.persistence.persistence.repositories.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CreatePurchaseIMPL implements CreatePurchaseOperation {
    private final PurchaseRepository purchaseRepository;
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public CreatePurchaseResponse operationProcess(CreatePurchaseRequest request) {
        List<ItemStorage> itemStorageList =itemStorageRepository.findAll();
        Boolean successful = checkItemsWithEnoughQuantity(request.getItems(),itemStorageList)
                &&request.getUserBalance()>=request.getTotalPrice();
        ArrayList<ItemStorage> list=new ArrayList<>();

        if(successful){
           request.getItems().entrySet().stream()
                   .forEach(entry->{
                    ItemStorage itemStorage=itemStorageList.stream()
                            .filter(item ->item.getItemId().equals(entry.getKey()))
                            .findFirst()
                            .orElseThrow(()->new RuntimeException("Not Found Storage"));
                    itemStorage.setQuantity(itemStorage.getQuantity()-entry.getValue());
                    list.add(itemStorage);
           });
           itemStorageRepository.saveAll(list);
        }


        purchaseRepository.save(Purchase.builder()
                .userId(request.getUserId())
                        .purchaseDate(new Timestamp(System.currentTimeMillis()))

                .totalPrice(request.getTotalPrice())
                .items(request.getItems())
                .successful(successful)
                .build());

        return CreatePurchaseResponse
                .builder()
                .successful(successful)
                .totalPrice(request.getTotalPrice())
                .purchaseDate(new Timestamp(System.currentTimeMillis()))
                .build();
    }
    public  boolean checkItemsWithEnoughQuantity(Map<UUID, Integer> items,List<ItemStorage> itemStorageList) {
       return items.entrySet().stream()
                .allMatch(entry -> itemStorageList.stream()
                        .anyMatch(item -> item.getItemId().equals(entry.getKey()) && item.getQuantity() >= entry.getValue()));
    }

}
