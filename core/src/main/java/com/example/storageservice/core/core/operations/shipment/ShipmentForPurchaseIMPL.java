package com.example.storageservice.core.core.operations.shipment;

import com.example.storageservice.api.api.operations.shipment.forpurchase.ShipmentForPurchaseOperation;
import com.example.storageservice.api.api.operations.shipment.forpurchase.ShipmentForPurchaseRequest;
import com.example.storageservice.api.api.operations.shipment.forpurchase.ShipmentForPurchaseResponse;
import com.example.storageservice.persistence.persistence.entities.Shipment;
import com.example.storageservice.persistence.persistence.repositories.ShipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ShipmentForPurchaseIMPL implements ShipmentForPurchaseOperation {
    private final ShipmentRepository shipmentRepository;

    @Override
    public ShipmentForPurchaseResponse operationProcess(ShipmentForPurchaseRequest request) {
        List<Shipment> shipments=shipmentRepository.findAllByPurchase_Id(request.getPurchaseId());
        return ShipmentForPurchaseResponse.builder()
                .shipments(shipments)
                .build();
    }
}
