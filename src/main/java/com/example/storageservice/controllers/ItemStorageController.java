package com.example.storageservice.controllers;

import com.example.storageservice.api.operations.itemStorage.changePrice.ChangePriceItemStorageRequest;
import com.example.storageservice.api.operations.itemStorage.changePrice.ChangePriceItemStorageService;
import com.example.storageservice.api.operations.itemStorage.create.CreateItemStorageRequest;
import com.example.storageservice.api.operations.itemStorage.create.CreateItemStorageService;
import com.example.storageservice.api.operations.itemStorage.exportItem.ExportItemStorageRequest;
import com.example.storageservice.api.operations.itemStorage.exportItem.ExportItemStorageService;
import com.example.storageservice.api.operations.itemStorage.get.GetItemStorageRequest;
import com.example.storageservice.api.operations.itemStorage.get.GetItemStorageService;
import com.example.storageservice.api.operations.itemStorage.importItem.ImportItemStorageRequest;
import com.example.storageservice.api.operations.itemStorage.importItem.ImportItemStorageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/itemStorage")
public class ItemStorageController {

    private final ImportItemStorageService importItemStorageService;
    private final ExportItemStorageService exportItemStorageService;
    private final ChangePriceItemStorageService changePriceItemStorageService;
    private final CreateItemStorageService createItemStorageService;
    private final GetItemStorageService getItemStorageService;

    @PutMapping("/import")
    public ResponseEntity importItemStorage(@RequestBody ImportItemStorageRequest item){
        return ResponseEntity.ok(importItemStorageService.importItem(item));
    }
    @PutMapping("/export")
    public ResponseEntity exportItemStorage(@RequestBody ExportItemStorageRequest item){
        return ResponseEntity.ok(exportItemStorageService.exportItem(item));
    }
    @PutMapping("/changePrice")
    public ResponseEntity changePrice(@RequestBody ChangePriceItemStorageRequest newPrice){
        return ResponseEntity.ok(changePriceItemStorageService.changePrice(newPrice));
    }
    @PostMapping("/createItemStorage")
    public ResponseEntity createItemStorage(@Valid @RequestBody CreateItemStorageRequest itemStorage){

        return ResponseEntity.ok(createItemStorageService.createItemStorage(itemStorage));
    }
    @GetMapping("/getItemStorage")
    public ResponseEntity getItemStorage(@RequestBody GetItemStorageRequest itemStorage){
        return ResponseEntity.ok(getItemStorageService.getItem(itemStorage));
    }

}
