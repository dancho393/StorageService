package com.example.storageservice.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "storages")
public class ItemStorage {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    private UUID itemId;

    private int quantity;

    private Float price;
}
