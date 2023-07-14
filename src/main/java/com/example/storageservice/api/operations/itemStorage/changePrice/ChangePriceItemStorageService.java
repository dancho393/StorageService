package com.example.storageservice.api.operations.itemStorage.changePrice;

import org.springframework.stereotype.Service;

@Service
public interface ChangePriceItemStorageService {
    public ChangePriceItemStorageResponse changePrice(ChangePriceItemStorageRequest newPrice);
}
