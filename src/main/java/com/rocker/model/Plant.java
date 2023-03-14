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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"plantHeight", "plantSpread",
		"commonName","difficultyLevel",
		"temperature","typeOfPlant"
})})
public class Plant {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer plantId;

    @NotNull(message = "Plant height can not be null")
    @Min(value = 1, message = "Planter height is must be greater than equal to 1")
    private Integer plantHeight;
    
    @NotBlank(message = "Plant Spread can not be blank")
    private String plantSpread;
    
    @NotBlank(message = "Plant name can not be blank")
    private String commonName;
    
    @NotBlank(message = "BloomTime can not be blank")
    private String bloomTime;
    
    @NotBlank(message = "Provide is it medicinal or Culinary Use ")
    private String medicinalOrCulinaryUse;

    private String difficultyLevel;

    private String temperature;
    
    @NotBlank(message = "Type Of Plant can not be blank")
    private String typeOfPlant;
    
    @NotNull(message = "Plant Description can not be null")
    private String plantDescription;
    
    @NotNull(message = "Plant Stock can not be null")
    @Min(value = 1, message = "Plant Stock must be greater than equal to 1")
    private Integer plantStock;
    
    @NotNull(message = "plant cost can not be null")
    @Min(value = 1, message = "Planter cost must be greater than equal to 1")
    private Double plantCost;
}
