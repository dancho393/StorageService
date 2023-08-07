package com.example.storageservice.persistence.persistence.repositories;

import com.example.storageservice.persistence.persistence.entities.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {
    //Page<Purchase> findAll(Pageable pageable);
}
