package com.example.storageservice.persistence.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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

    @Min(value = 0,message = "Quantity must be greater or equal to zero")
    private int quantity;
    @Min(value = 0,message = "Price must be greater or equal to zero")
    private Float price;
}
