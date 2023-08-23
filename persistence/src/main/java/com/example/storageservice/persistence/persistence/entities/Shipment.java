package com.example.storageservice.persistence.persistence.entities;

import com.example.storageservice.persistence.persistence.enums.EstimatedTime;
import com.example.storageservice.persistence.persistence.enums.ShipmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;
import java.util.Map;
import java.util.UUID;

@Table(name = "shipments")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String fromCountry;
    private String fromCity;
    private String fromContinent;
    private String toCountry;
    private String toCity;
    private String toContinent;

    private String estimatedTime;

    private String estimatedArrival;

    private String arrival;

    @Enumerated(EnumType.STRING)
    private ShipmentStatus shipmentStatus;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    private UUID itemId;

    private int itemQuantity;

    private UUID takerUserId;

    private String takenTime;

}
