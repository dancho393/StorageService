package com.example.storageservice.core.core.operations.purchase.getallforuser;

import com.example.storageservice.api.api.operations.purchase.getforuser.GetPurchaseForUserOperation;
import com.example.storageservice.api.api.operations.purchase.getforuser.GetPurchaseForUserRequest;
import com.example.storageservice.api.api.operations.purchase.getforuser.GetPurchaseForUserResponse;
import com.example.storageservice.persistence.persistence.entities.Purchase;
import com.example.storageservice.persistence.persistence.repositories.PurchaseRepository;
import com.example.zoostore.api.operations.item.getrecommendee.GetRecommendeeItemsRequest;
import com.example.zoostore.api.operations.item.getrecommendee.GetRecommendeeUser;
import com.example.zoostore.restexport.ZooStoreRestClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GetPurchaseForUserIMPL implements GetPurchaseForUserOperation {
    private final PurchaseRepository purchaseRepository;
    private final ZooStoreRestClient zooStoreRestClient;
    @Override
    public GetPurchaseForUserResponse operationProcess(GetPurchaseForUserRequest request) {
        List<Purchase> purchaseList= purchaseRepository.findAllByUserId(request.getUserId());
        List<GetRecommendeeUser> responseList=new ArrayList<>();
                purchaseList.stream()
                        .filter(Purchase::getSuccessful)
                        .forEach(purchase -> {
                            responseList.add( GetRecommendeeUser.builder()
                                    .id(purchase.getId())
                                    .userId(purchase.getUserId())
                                    .purchaseDate(purchase.getPurchaseDate())
                                    .items(purchase.getItems())
                                    .successful(purchase.getSuccessful())
                                    .totalPrice(purchase.getTotalPrice())
                                    .build());
                        });

        return GetPurchaseForUserResponse.builder()
                .purchases(zooStoreRestClient.recommendedItems(GetRecommendeeItemsRequest.builder()
                        .purchaseList(responseList)
                                 .page(request.getPage())
                                 .build())
                        .getItems()).build();
    }
}
