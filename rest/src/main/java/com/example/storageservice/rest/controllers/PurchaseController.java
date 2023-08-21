package com.example.storageservice.rest.controllers;

import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseOperation;
import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseRequest;
import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseResponse;
import com.example.storageservice.api.api.operations.purchase.getAll.GetAllOperation;
import com.example.storageservice.api.api.operations.purchase.getAll.GetAllRequest;
import com.example.storageservice.api.api.operations.purchase.getAll.GetAllResponse;
import com.example.storageservice.api.api.operations.purchase.getforuser.GetPurchaseForUserOperation;
import com.example.storageservice.api.api.operations.purchase.getforuser.GetPurchaseForUserRequest;
import com.example.storageservice.api.api.operations.purchase.getforuser.GetPurchaseForUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/purchase")
@AllArgsConstructor
public class PurchaseController {
    private final GetAllOperation getAll;
    private final CreatePurchaseOperation createPurchase;
    private final GetPurchaseForUserOperation getPurchaseForUserOperation;
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
    @PostMapping("/{userId}/{page}")
    public ResponseEntity<GetPurchaseForUserResponse> getByUserId(@PathVariable UUID userId,@PathVariable int page){
        return ResponseEntity.ok(getPurchaseForUserOperation
                .operationProcess(GetPurchaseForUserRequest.builder()
                .page(page)
                .userId(userId).build()));

    }
}
