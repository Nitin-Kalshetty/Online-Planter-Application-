package com.rocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocker.model.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {
	public List<Plant> findByPlantHeightBetween(Double min, Double max);

	public List<Plant> findByPlantSpread(String plantSpread);

	public List<Plant> findByCommonName(String commonName);

	public List<Plant> findByTypeOfPlant(String typeOfPlant);

	public List<Plant> findByTemperatureBetween(Double min, Double max);

	public List<Plant> findByPlantCostBetween(Double min, Double max);

}
