package com.example.storageservice.rest.controllers;


import com.example.storageservice.api.api.operations.itemStorage.changePrice.ChangePriceItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.changePrice.ChangePriceItemStorageService;
import com.example.storageservice.api.api.operations.itemStorage.create.CreateItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.create.CreateItemStorageService;
import com.example.storageservice.api.api.operations.itemStorage.edit.EditItemStorageService;
import com.example.storageservice.api.api.operations.itemStorage.exportItem.ExportItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.exportItem.ExportItemStorageService;
import com.example.storageservice.api.api.operations.itemStorage.get.GetItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.get.GetItemStorageService;
import com.example.storageservice.api.api.operations.itemStorage.importItem.ImportItemStorageRequest;
import com.example.storageservice.api.api.operations.itemStorage.importItem.ImportItemStorageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/itemStorage")
@RequiredArgsConstructor
public class ItemStorageController {

    private final ImportItemStorageService importItemStorageService;
    private final ExportItemStorageService exportItemStorageService;
    private final ChangePriceItemStorageService changePriceItemStorageService;
    private final CreateItemStorageService createItemStorageService;
    private final GetItemStorageService getItemStorageService;
    private final EditItemStorageService editItemStorageService;//NotUsedYet

    @PutMapping("/import")
    public ResponseEntity importItemStorage(@Valid @RequestBody ImportItemStorageRequest item){
        return ResponseEntity.ok(importItemStorageService.operationProcess(item));
    }
    @PutMapping("/export")
    public ResponseEntity exportItemStorage(@Valid @RequestBody ExportItemStorageRequest item){
        return ResponseEntity.ok(exportItemStorageService.operationProcess(item));
    }
    @PutMapping("/changePrice")
    public ResponseEntity changePrice(@Valid @RequestBody ChangePriceItemStorageRequest newPrice){
        return ResponseEntity.ok(changePriceItemStorageService.operationProcess(newPrice));
    }
    @PostMapping("/createItemStorage")
    public ResponseEntity createItemStorage(@Valid @RequestBody CreateItemStorageRequest itemStorage){

        return ResponseEntity.ok(createItemStorageService.operationProcess(itemStorage));
    }
    @GetMapping("/getItemStorage")
    public ResponseEntity getItemStorage(@Valid @RequestBody GetItemStorageRequest itemStorage){
        return ResponseEntity.ok(getItemStorageService.operationProcess(itemStorage));
    }


}
