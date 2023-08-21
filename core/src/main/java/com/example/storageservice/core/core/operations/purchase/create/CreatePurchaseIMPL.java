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

        Float discountedPrice=discount(request.getTotalPrice(), request.getDiscountPoints());
        List<ItemStorage> itemStorageList =itemStorageRepository.findAll();
        Boolean successful = checkItemsWithEnoughQuantity(request.getItems(),itemStorageList)
                &&request.getUserBalance()>=discountedPrice;
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

                .totalPrice(discountedPrice)
                .items(request.getItems())
                .successful(successful)
                .build());

        return CreatePurchaseResponse
                .builder()
                .discountedPrice(discountedPrice)
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
    public Float discount(Float totalPrice,int discountPoints){
        if(discountPoints==0)
            return totalPrice;
        if (discountPoints>0&&discountPoints<2000)
            return (totalPrice/100)*95;//5% discount
        if(discountPoints>=2000&&discountPoints<4000)
            return (totalPrice/100)*90;//10% discount
        if(discountPoints>=4000&&discountPoints<6000)
            return (totalPrice/100)*85;//15% discount
        if(discountPoints>=6000&&discountPoints<8000)
            return (totalPrice/100)*80;//20% discount
        if(discountPoints>=8000)
            return (totalPrice/100)*75;//25% discount


        return totalPrice;

    }

}
