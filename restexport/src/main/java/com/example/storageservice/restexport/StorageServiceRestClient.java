package com.example.storageservice.restexport;

import com.example.storageservice.api.api.operations.itemStorage.get.GetItemStorageResponse;
import com.example.storageservice.api.api.operations.itemStorage.getByItemId.GetByItemResponse;
import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseRequest;
import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseResponse;
import com.example.storageservice.api.api.operations.purchase.getAll.GetAllResponse;
import com.example.storageservice.api.api.operations.purchase.getforuser.GetPurchaseForUserResponse;
import com.example.storageservice.api.api.operations.shipment.arive.ShipmentArrivalResponse;
import com.example.storageservice.api.api.operations.shipment.forpurchase.ShipmentForPurchaseRequest;
import com.example.storageservice.api.api.operations.shipment.forpurchase.ShipmentForPurchaseResponse;
import com.example.storageservice.api.api.operations.shipment.take.TakeShipmentResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

@Headers({"Content-Type: application/json"})
public interface StorageServiceRestClient {
    @RequestLine("GET /item-storages/{id}")

    GetItemStorageResponse getItemStorage(@Param String id);

    @RequestLine("GET /item-storages/byItemId/{itemId}")

    GetByItemResponse getStorageById(@Param String itemId);

    @RequestLine("POST /purchase/new")

    CreatePurchaseResponse createPurchase(@RequestBody CreatePurchaseRequest request);

    @RequestLine("GET /purchase/all/{page}")

    GetAllResponse getAllPurchase(@Param  int page);

    @RequestLine("POST /purchase/{userId}/{page}")

    GetPurchaseForUserResponse recommend(@Param String userId,@Param int page);

    @RequestLine("POST /shipments/all")
    ShipmentForPurchaseResponse shipmentForPurchase(@RequestBody ShipmentForPurchaseRequest request);

    @RequestLine("POST /shipments/{shipmentId}")
    ShipmentArrivalResponse shipmentArrival(@Param String shipmentId);

    @RequestLine("POST shipments/{shipmentId}/{userId}")
    TakeShipmentResponse takeShipment(@Param String shipmentId,@Param String userId);

}
