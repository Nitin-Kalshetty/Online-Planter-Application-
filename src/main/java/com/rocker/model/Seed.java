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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"commanName", "bloomTime",
		"watering","difficultLevel",
		"temperature","typeOfSeed",
		"seedStock","seedsCost","seedPerPacket"
})})
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
	
	@NotBlank(message = "DifficultLevel is Mandatory")
	private Integer difficultyLevel;
	
	@NotBlank(message = "Temparature is Mandatory")
	private Integer temperature;
	
	@NotBlank(message = "Type Of Seed is Mandatory")
	private String typeOfSeed;
	
	@NotBlank(message = "Seed Description is Mandatory")
	private String seedDescription;
	
	@NotNull(message = "seed value can not be null")
	@Min(value =  1,message = "Seed value must be greater than equal to 1")
	private Integer seedStock;
	
	@NotNull(message = "Seed Cost should not be null")
	@Min(value = 1 , message = "Seed cost must be greater than equal to 1")
	private Double seedCost;
	
	@NotNull(message = "Seed Per Packed should not be null")
	@Min(value =  1,message = "Seed per packet must be greater than equal to 1")
	private Integer seedsPerPacket;
}
