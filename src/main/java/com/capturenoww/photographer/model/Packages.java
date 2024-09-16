package com.capturenoww.photographer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Entity
@Data
@ToString(exclude = "photographer")
public class Packages {

	@Id
	@Column
	private String id;

	private String packageName;
	
	private String category;

	private int eventRate;
	
	private int oneDayRate;
	
	private int oneHourRate;
	
	private int videoRate;

    @Column(length = 4000)
	private String description;

	@JsonBackReference
	@ManyToOne
	private Photographer photographer;

	public Packages(){
		this.id = generateCustomId();
	}

	private String generateCustomId() {
		// Implement your custom ID generation logic here
		// Example: return UUID.randomUUID().toString();
		// You can use any logic to create a unique identifier
		return "CN-P" + UUID.randomUUID();
	}
	
}
