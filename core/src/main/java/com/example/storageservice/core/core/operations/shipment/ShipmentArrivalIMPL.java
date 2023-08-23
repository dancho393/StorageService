package com.example.storageservice.core.core.operations.shipment;

import com.example.storageservice.api.api.operations.shipment.arive.ShipmentArrivalOperation;
import com.example.storageservice.api.api.operations.shipment.arive.ShipmentArrivalRequest;
import com.example.storageservice.api.api.operations.shipment.arive.ShipmentArrivalResponse;
import com.example.storageservice.core.core.exceptions.ResourceNotFoundException;
import com.example.storageservice.persistence.persistence.entities.Shipment;
import com.example.storageservice.persistence.persistence.enums.ShipmentStatus;
import com.example.storageservice.persistence.persistence.repositories.ShipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class ShipmentArrivalIMPL implements ShipmentArrivalOperation {
    private final ShipmentRepository shipmentRepository;
    @Override
    public ShipmentArrivalResponse operationProcess(ShipmentArrivalRequest request) {
        Shipment shipment = shipmentRepository.findById(request.getShipmentId())
                .orElseThrow(()->new ResourceNotFoundException("Shipment Not found"));
        shipment.setArrival(LocalDate.now().toString());
        shipment.setShipmentStatus(ShipmentStatus.DONE);
        if(LocalDate.now().isAfter(LocalDate.parse(shipment.getEstimatedArrival())))
            shipment.setShipmentStatus(ShipmentStatus.DONELATE);
        shipmentRepository.save(shipment);


        return ShipmentArrivalResponse.builder()
                .status(shipment.getShipmentStatus().toString())
                .build();
    }
}
