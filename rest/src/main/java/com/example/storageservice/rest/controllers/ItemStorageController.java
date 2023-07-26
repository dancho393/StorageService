package com.example.storageservice.rest.controllers;


import com.example.storageservice.api.api.operations.itemStorage.changePrice.ChangePriceItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.changePrice.ChangePriceItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.create.CreateItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.create.CreateItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.edit.EditItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.exportItem.ExportItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.exportItem.ExportItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.get.GetItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.get.GetItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.importItem.ImportItemStorageOperation;
import com.example.storageservice.api.api.operations.itemStorage.importItem.ImportItemStorageRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/itemStorages")
@RequiredArgsConstructor
public class ItemStorageController {

    private final ImportItemStorageOperation importItemStorageOperation;
    private final ExportItemStorageOperation exportItemStorageOperation;
    private final ChangePriceItemStorageOperation changePriceItemStorageOperation;
    private final CreateItemStorageOperation createItemStorageOperation;
    private final GetItemStorageOperation getItemStorageOperation;
    private final EditItemStorageOperation editItemStorageOperation;//NotUsedYet

    @PutMapping("/import")
    public ResponseEntity importItemStorage(@Valid @RequestBody ImportItemStorageRequest item){
        return ResponseEntity.ok(importItemStorageOperation.operationProcess(item));
    }
    @PutMapping("/export")
    public ResponseEntity exportItemStorage(@Valid @RequestBody ExportItemStorageRequest item){
        return ResponseEntity.ok(exportItemStorageOperation.operationProcess(item));
    }
    @PutMapping("/changePrice")
    public ResponseEntity changePrice(@Valid @RequestBody ChangePriceItemStorageRequest newPrice){
        return ResponseEntity.ok(changePriceItemStorageOperation.operationProcess(newPrice));
    }
    @PostMapping("/createItemStorage")
    public ResponseEntity createItemStorage(@Valid @RequestBody CreateItemStorageRequest itemStorage){

        return ResponseEntity.ok(createItemStorageOperation.operationProcess(itemStorage));
    }
    @GetMapping("/{id}")
    public ResponseEntity getItemStorage(@Valid @PathVariable UUID id){
        GetItemStorageRequest itemStorage = GetItemStorageRequest.builder()
                .id(id)
                .build();
        return ResponseEntity.ok(getItemStorageOperation.operationProcess(itemStorage));
    }


}
