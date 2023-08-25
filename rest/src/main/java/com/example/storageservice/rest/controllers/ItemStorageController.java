package com.example.storageservice.rest.controllers;


import com.example.storageservice.api.api.operations.itemStorage.changePrice.ChangePriceItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.changePrice.ChangePriceItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.changePrice.ChangePriceItemStorageResponse;
import com.example.storageservice.api.api.operations.itemStorage.changeQuantity.ChangeQuantityOperation;
import com.example.storageservice.api.api.operations.itemStorage.changeQuantity.ChangeQuantityRequest;
import com.example.storageservice.api.api.operations.itemStorage.changeQuantity.ChangeQuantityResponse;
import com.example.storageservice.api.api.operations.itemStorage.create.CreateItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.create.CreateItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.create.CreateItemStorageResponse;
import com.example.storageservice.api.api.operations.itemStorage.edit.EditItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.get.GetItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.get.GetItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.get.GetItemStorageResponse;
import com.example.storageservice.api.api.operations.itemStorage.getByItemId.GetByItemIdOperation;
import com.example.storageservice.api.api.operations.itemStorage.getByItemId.GetByItemIdRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/item-storages")
@RequiredArgsConstructor
public class ItemStorageController {

    private final ChangePriceItemStorageOperation changePriceItemStorageOperation;
    private final CreateItemStorageOperation createItemStorageOperation;
    private final GetItemStorageOperation getItemStorageOperation;
    private final ChangeQuantityOperation changeQuantityOperation;
    private final EditItemStorageOperation editItemStorageOperation;//NotUsedYet
    private final GetByItemIdOperation getByItemIdOperation;
    @PutMapping("/quantity")
    public ResponseEntity<ChangeQuantityResponse> changeQuantity(@RequestBody ChangeQuantityRequest itemStorage){
        return ResponseEntity.ok(changeQuantityOperation.operationProcess(itemStorage));
    }

    @PutMapping("/price")
    public ResponseEntity<ChangePriceItemStorageResponse> changePrice(@Valid @RequestBody ChangePriceItemStorageRequest newPrice){
        return ResponseEntity.ok(changePriceItemStorageOperation.operationProcess(newPrice));
    }
    @PostMapping
    public ResponseEntity<CreateItemStorageResponse> createItemStorage(@Valid @RequestBody CreateItemStorageRequest itemStorage){

        return ResponseEntity.ok(createItemStorageOperation.operationProcess(itemStorage));
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetItemStorageResponse> getItemStorage(@Valid @PathVariable UUID id){
        GetItemStorageRequest itemStorage = GetItemStorageRequest.builder()
                .id(id)
                .build();
        return ResponseEntity.ok(getItemStorageOperation.operationProcess(itemStorage));
    }
    @GetMapping("/byItemId/{itemId}")
    public ResponseEntity getAllItemStorages(@PathVariable UUID itemId){
        return ResponseEntity.ok(getByItemIdOperation.operationProcess(GetByItemIdRequest.builder().itemId(itemId).build()));
    }


}
