package com.rocker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "commonName", "bloomTime",
		"watering", "difficultyLevel",
		"temperature", "typeOfSeed",
		"seedStock", "seedCost", "seedsPerPacket"
}) })
public class Seed {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer seedId;

	@NotBlank(message = "Seed Name is Mandatory")
	private String commonName;

	@NotBlank(message = "Bloom Time is Mandatory")
	private String bloomTime;

	@NotBlank(message = "Watering is Mandatory")
	private String watering;

	private Integer difficultyLevel;

	private Double temperature;

	@NotBlank(message = "Type Of Seed is Mandatory")
	private String typeOfSeed;

	@NotBlank(message = "Seed Description is Mandatory")
	private String seedDescription;

	@Min(value = 1, message = "Seed value must be greater than equal to 1")
	private Integer seedStock;

	@Min(value = 1, message = "Seed cost must be greater than equal to 1")
	private Double seedCost;

	@Min(value = 1, message = "Seed per packet must be greater than equal to 1")
	private Integer seedsPerPacket;
}
