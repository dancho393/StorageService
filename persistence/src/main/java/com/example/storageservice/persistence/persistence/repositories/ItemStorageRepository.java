package com.example.storageservice.persistence.persistence.repositories;


import com.example.storageservice.persistence.persistence.entities.ItemStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemStorageRepository extends JpaRepository<ItemStorage, UUID> {
}
