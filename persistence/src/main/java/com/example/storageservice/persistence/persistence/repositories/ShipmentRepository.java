package com.example.storageservice.persistence.persistence.repositories;

import com.example.storageservice.persistence.persistence.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, UUID> {
    List<Shipment> findAllByPurchase_Id(UUID purchaseId);
}
