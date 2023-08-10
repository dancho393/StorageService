package com.example.storageservice.persistence.persistence.repositories;

import com.example.storageservice.persistence.persistence.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {
    List<Purchase> findAllByUserId(UUID userId);
}
