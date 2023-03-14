package com.rocker.services;

import java.util.List;

import com.rocker.exceptions.CustomerException;
import com.rocker.exceptions.PlantException;
import com.rocker.model.Plant;

public interface PlantService {

	 public Plant addPlant(Plant plant) throws CustomerException;

	    public Plant updatePlant(Plant plant) throws PlantException,CustomerException;

	    public Plant deletePlantById(Integer plantId) throws PlantException,CustomerException;

	    public Plant viewPlantById(Integer plantId) throws PlantException, CustomerException;

	    public List<Plant> viewPlantByName(String name) throws PlantException;

	    public List<Plant> viewAllPlants() throws PlantException;

	    public List<Plant> viewPlantsByPlantType(String type) throws PlantException;
}
