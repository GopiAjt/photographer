package com.capturenoww.photographer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class PhotographerRatings {

	@Id
	private String id;
	
	private int ratings;
	
	private String comments;

	private LocalDateTime ratingDate;

//	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Photographer photographer;

//	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "photographer_id")
	private  Customer customer;

	public PhotographerRatings(){
		this.id = generateCustomId();
	}
	private String generateCustomId() {
		// Implement your custom ID generation logic here
		// Example: return UUID.randomUUID().toString();
		// You can use any logic to create a unique identifier
		return "CN-R" + UUID.randomUUID().toString();
	}
}
