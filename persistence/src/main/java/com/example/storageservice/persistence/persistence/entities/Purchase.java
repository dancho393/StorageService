package com.example.storageservice.persistence.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

@Table(name = "purchases")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Boolean successful;

    private Timestamp purchaseDate;
    @ElementCollection
    private Map<UUID,Integer> items;

    private Float totalPrice;

    private UUID userId;
    
}
