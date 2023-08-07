package com.example.storageservice.core.core.operations.purchase.getAll;

import com.example.storageservice.api.api.operations.base.OperationRequest;
import com.example.storageservice.api.api.operations.base.OperationResponse;
import com.example.storageservice.api.api.operations.purchase.getAll.GetAllOperation;
import com.example.storageservice.api.api.operations.purchase.getAll.GetAllPurchase;
import com.example.storageservice.api.api.operations.purchase.getAll.GetAllRequest;
import com.example.storageservice.api.api.operations.purchase.getAll.GetAllResponse;
import com.example.storageservice.persistence.persistence.entities.Purchase;
import com.example.storageservice.persistence.persistence.repositories.PurchaseRepository;
import com.example.zoostore.api.operations.item.get.GetItemResponse;
import com.example.zoostore.restexport.ZooStoreRestClient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class GetAllIMPL implements GetAllOperation {
    private final PurchaseRepository purchaseRepository;
    private final ZooStoreRestClient zooStoreRestClient;

    @Override
    public GetAllResponse operationProcess(GetAllRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(),5);
        Page<Purchase> pages = purchaseRepository.findAll(pageable);
        List<GetAllPurchase> purchases=new ArrayList<>();
        pages.getContent().stream()
                .forEach(item->{
                    Map<String,Integer> items= new HashMap<>();
                    item.getItems().entrySet().forEach(cItem->{
                        GetItemResponse response=zooStoreRestClient.getItemById(cItem.getKey().toString());
                        items.put(response.getTitle(),cItem.getValue());
                    });

                    GetAllPurchase purchase=GetAllPurchase.builder()
                            .id(item.getId())
                            .purchaseDate(item.getPurchaseDate())
                            .userId(item.getUserId())
                            .items(items)
                            .totalPrice(item.getTotalPrice())
                            .successful(item.getSuccessful())
                            .build();
                    purchases.add(purchase);
                });
        return GetAllResponse
                .builder()
                .purchaseList(purchases)
                .build();
    }
}
