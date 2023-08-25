package com.example.storageservice.core.core.operations.shipment;

import com.example.storageservice.api.api.operations.shipment.take.TakeShipmentOperation;
import com.example.storageservice.api.api.operations.shipment.take.TakeShipmentRequest;
import com.example.storageservice.api.api.operations.shipment.take.TakeShipmentResponse;
import com.example.storageservice.core.core.exceptions.ResourceNotFoundException;
import com.example.storageservice.persistence.persistence.entities.Shipment;
import com.example.storageservice.persistence.persistence.enums.ShipmentStatus;
import com.example.storageservice.persistence.persistence.repositories.ShipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class TakeShipmentIMPL implements TakeShipmentOperation {
    private final ShipmentRepository shipmentRepository;

    @Override
    public TakeShipmentResponse operationProcess(TakeShipmentRequest request) {
        Shipment shipment = shipmentRepository.findById(request.getShipmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Shipment Not Found"));
        shipment.setTakerUserId(request.getUserId());
        shipment.setShipmentStatus(ShipmentStatus.TAKEN);
        shipment.setTakenTime(LocalDateTime.now().toString());
        shipmentRepository.save(shipment);

        return TakeShipmentResponse.builder()
                .shipmentStatus(shipment.getShipmentStatus().toString())
                .takenTime(shipment.getTakenTime())
                .refundedMoney(calculateRefundMoney(shipment))
                .userId(shipment.getPurchase().getUserId())
                .build();

    }
    private Float calculateRefundMoney(Shipment shipment){
        List<Shipment> shipmentList = shipmentRepository.findAllByPurchase_Id(shipment.getPurchase().getId());
        boolean hasAllArrived= shipmentList.stream()
                .noneMatch(cShipment -> cShipment.getShipmentStatus().toString()
                        .equals(ShipmentStatus.WAITING.toString()));

        boolean isAnyShipmentLate=shipmentList.stream()
                .anyMatch(cShipment -> cShipment.getShipmentStatus().toString()
                        .equals(ShipmentStatus.DONELATE.toString()));

        float refundMoney=0.0f;
        if(hasAllArrived &&isAnyShipmentLate)
            refundMoney=shipment.getPurchase().getTotalPrice()*0.05f;//5% of the price refunded
        return refundMoney;
    }
}
