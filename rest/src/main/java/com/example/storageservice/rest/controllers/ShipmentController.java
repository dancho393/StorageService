package com.example.storageservice.rest.controllers;

import com.example.storageservice.api.api.operations.shipment.arive.ShipmentArrivalOperation;
import com.example.storageservice.api.api.operations.shipment.arive.ShipmentArrivalRequest;
import com.example.storageservice.api.api.operations.shipment.arive.ShipmentArrivalResponse;
import com.example.storageservice.api.api.operations.shipment.forpurchase.ShipmentForPurchaseOperation;
import com.example.storageservice.api.api.operations.shipment.forpurchase.ShipmentForPurchaseRequest;
import com.example.storageservice.api.api.operations.shipment.forpurchase.ShipmentForPurchaseResponse;
import com.example.storageservice.api.api.operations.shipment.take.TakeShipmentOperation;
import com.example.storageservice.api.api.operations.shipment.take.TakeShipmentRequest;
import com.example.storageservice.api.api.operations.shipment.take.TakeShipmentResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/shipments")
public class ShipmentController {
    private final ShipmentArrivalOperation shipmentArrivalOperation;
    private final ShipmentForPurchaseOperation shipmentForPurchase;
    private final TakeShipmentOperation takeShipment;

    @PostMapping("/{shipmentId}")
    public ResponseEntity<ShipmentArrivalResponse> arrival(@PathVariable UUID shipmentId){
        ShipmentArrivalRequest request=ShipmentArrivalRequest.builder()
                .shipmentId(shipmentId)
                .build();
        return ResponseEntity.ok(shipmentArrivalOperation
                .operationProcess(request));
    }
    @PostMapping("/all")
    public ResponseEntity<ShipmentForPurchaseResponse> allForUser(@RequestBody ShipmentForPurchaseRequest request){
        return ResponseEntity.ok(shipmentForPurchase.operationProcess(request));
    }
    @PostMapping("/{shipmentId}/{userId}")
    public ResponseEntity<TakeShipmentResponse> take(@PathVariable UUID shipmentId,
                                                     @PathVariable UUID userId){
        TakeShipmentRequest request = TakeShipmentRequest.builder()
                .shipmentId(shipmentId)
                .userId(userId)
                .build();
        return ResponseEntity.ok(takeShipment.operationProcess(request));
    }
}
