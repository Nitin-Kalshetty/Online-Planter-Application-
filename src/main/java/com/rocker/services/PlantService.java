package com.rocker.services;

import java.util.List;

import com.rocker.exceptions.CustomerException;
import com.rocker.exceptions.PlantException;
import com.rocker.model.Plant;

public interface PlantService {

	public Plant addPlant(Plant plant) throws PlantException;

	public Plant updatePlant(Plant plant) throws PlantException;

	public Plant deletePlantById(Integer plantId) throws PlantException;

	public Plant viewPlantById(Integer plantId) throws PlantException;

	public List<Plant> viewPlantsByName(String name) throws PlantException;

	public List<Plant> viewAllPlants() throws PlantException;

	public List<Plant> viewPlantsByPlantType(String type) throws PlantException;

	public List<Plant> viewPlantsByHeight(Double min, Double max) throws PlantException;

	public List<Plant> viewPlantsBySpread(String plantSpread) throws PlantException;

	public List<Plant> viewPlantsByTemperature(Double min, Double max) throws PlantException;

	public List<Plant> viewPlantsByCost(Double min, Double max) throws PlantException;
}
