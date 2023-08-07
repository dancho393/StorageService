package com.example.storageservice.rest.controllers;

import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseRequest;
import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseResponse;
import com.example.storageservice.api.api.operations.purchase.getAll.GetAllRequest;
import com.example.storageservice.api.api.operations.purchase.getAll.GetAllResponse;
import com.example.storageservice.core.core.operations.purchase.create.CreatePurchaseIMPL;
import com.example.storageservice.core.core.operations.purchase.getAll.GetAllIMPL;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
@AllArgsConstructor
public class PurchaseController {
    private final GetAllIMPL getAll;
    private final CreatePurchaseIMPL createPurchase;
    @GetMapping("/all/{page}")
    public ResponseEntity<GetAllResponse> getAll(@PathVariable int page){
        return ResponseEntity.ok(getAll.operationProcess(GetAllRequest.builder()
                .page(page)
                .build()));
    }
    @PostMapping("/new")
    public ResponseEntity<CreatePurchaseResponse> create(@RequestBody CreatePurchaseRequest request){
        return ResponseEntity.ok(createPurchase.operationProcess(request));
    }
}
