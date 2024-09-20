package com.capturenoww.photographer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Favorites {

    @Id
    private String id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "photographer_id")
    private Photographer photographer;

    public Favorites(){
        this.id = generateCustomId();
    }

    private String generateCustomId() {
        // Implement your custom ID generation logic here
        // Example: return UUID.randomUUID().toString();
        // You can use any logic to create a unique identifier
        return "CN-F" + UUID.randomUUID().toString();
    }
}
