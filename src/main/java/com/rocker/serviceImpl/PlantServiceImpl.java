package com.rocker.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rocker.exceptions.CustomerException;
import com.rocker.exceptions.PlantException;
import com.rocker.model.Plant;
import com.rocker.services.PlantService;

@Service
public class PlantServiceImpl implements PlantService{

	@Override
	public Plant addPlant(Plant plant) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plant updatePlant(Plant plant) throws PlantException, CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plant deletePlantById(Integer plantId) throws PlantException, CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plant viewPlantById(Integer plantId) throws PlantException, CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plant> viewPlantByName(String name) throws PlantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plant> viewAllPlants() throws PlantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plant> viewPlantsByPlantType(String type) throws PlantException {
		// TODO Auto-generated method stub
		return null;
	}

}
