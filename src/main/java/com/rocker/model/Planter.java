package com.rocker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"planterheight", "planterCapacity",
												"drainageHoles","planterColor",
												"planterShape"})})
public class Planter {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planterId;
	
	@NotNull(message = "Planter height should not be null")
	@Min(value = 1, message = "Planter height is must be greater than equal to 1")
	private Double planterheight;
	
	@NotNull(message = "Planter capacity should not be null")
	@Min(value = 1, message = "Planter capacity is must be greater than equal to 1")
	private Double planterCapacity;
	
	@NotNull(message = "Planter Holes should not be null")
	@Min(value = 1, message = "Planter holes is must be greater than equal to 1")
	private Integer drainageHoles;
	
	@NotNull(message = "Planter Color should not be null")
	private String planterColor;
	
	@NotNull(message = "Planter Shape should not be null")
	private String planterShape;
	
	@NotNull(message = "Planter Stock should not be null")
	@Min(value = 0, message = "Planter stock is must be greater than equal to 1")
	private Integer planterStock;
	
	@NotNull(message = "Planter Cost should not be null")
	@Min(value = 1, message = "Planter cost is must be greater than equal to 1")
	private Double planterCost;
}
