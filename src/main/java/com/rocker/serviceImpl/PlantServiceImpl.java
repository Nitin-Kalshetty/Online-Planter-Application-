package com.rocker.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.rocker.exceptions.PlantException;
import com.rocker.model.Plant;
import com.rocker.repository.PlantRepository;
import com.rocker.services.PlantService;

@Service
public class PlantServiceImpl implements PlantService {

	@Autowired
	private PlantRepository plantRepo;

	@Override
	public Plant addPlant(Plant plant) throws PlantException {
		try {
			return plantRepo.save(plant);
		} catch (DataIntegrityViolationException e) {
			throw new PlantException("Already plant exists please use Update to add");
		}
	}

	@Override
	public Plant updatePlant(Plant plant) throws PlantException {
		Optional<Plant> opt = plantRepo.findById(plant.getPlantId());
		if (opt.isEmpty()) {
			throw new PlantException("There is no such plant please check");
		}
		Plant check = opt.get();
		UpdateValidator uv = new UpdateValidator();
		check.setBloomTime(uv.checker(plant.getBloomTime()) ? plant.getBloomTime() : check.getBloomTime());
		check.setCommonName(uv.checker(plant.getCommonName()) ? plant.getCommonName() : check.getCommonName());
		check.setDifficultyLevel(
				uv.checker(plant.getDifficultyLevel()) ? plant.getDifficultyLevel() : check.getDifficultyLevel());
		check.setMedicinalOrCulinaryUse(
				uv.checker(plant.getMedicinalOrCulinaryUse()) ? plant.getMedicinalOrCulinaryUse()
						: check.getMedicinalOrCulinaryUse());
		check.setPlantCost(uv.checker(plant.getPlantCost()) ? plant.getPlantCost() : check.getPlantCost());
		check.setPlantDescription(
				uv.checker(plant.getPlantDescription()) ? plant.getPlantDescription() : check.getPlantDescription());
		check.setPlantHeight(uv.checker(plant.getPlantHeight()) ? plant.getPlantHeight() : check.getPlantHeight());
		check.setPlantSpread(uv.checker(plant.getPlantSpread()) ? plant.getPlantSpread() : check.getPlantSpread());
		check.setPlantStock(uv.checker(plant.getPlantStock()) ? plant.getPlantStock() : check.getPlantStock());
		check.setTemperature(uv.checker(plant.getTemperature()) ? plant.getTemperature() : check.getTemperature());
		check.setTypeOfPlant(uv.checker(plant.getTypeOfPlant()) ? plant.getTypeOfPlant() : check.getTypeOfPlant());
		return plantRepo.save(check);
	}

	@Override
	public Plant deletePlantById(Integer plantId) throws PlantException {
		Optional<Plant> opt = plantRepo.findById(plantId);
		if (opt.isEmpty()) {
			throw new PlantException("No Plant Found with ID : " + plantId);
		}
		Plant plant = opt.get();
		plantRepo.delete(plant);
		return plant;
	}

	@Override
	public Plant viewPlantById(Integer plantId) throws PlantException {
		Optional<Plant> opt = plantRepo.findById(plantId);
		if (opt.isEmpty()) {
			throw new PlantException("No Plant Found with ID : " + plantId);
		}
		return opt.get();
	}

	@Override
	public List<Plant> viewPlantsByName(String name) throws PlantException {
		List<Plant> list = plantRepo.findByCommonName(name);
		if (list.isEmpty()) {
			throw new PlantException("There are no Plants with name : " + name);
		}
		return list;
	}

	@Override
	public List<Plant> viewAllPlants() throws PlantException {
		List<Plant> list = plantRepo.findAll();
		if (list.isEmpty()) {
			throw new PlantException("There are no Plants");
		}
		return list;
	}

	@Override
	public List<Plant> viewPlantsByPlantType(String type) throws PlantException {
		List<Plant> list = plantRepo.findByTypeOfPlant(type);
		if (list.isEmpty()) {
			throw new PlantException("There are no Plants with type : " + type);
		}
		return list;
	}

	@Override
	public List<Plant> viewPlantsByHeight(Double min, Double max) throws PlantException {
		List<Plant> list = plantRepo.findByPlantHeightBetween(min, max);
		if (list.isEmpty()) {
			throw new PlantException("There are no Plants In this range.");
		}
		return list;
	}

	@Override
	public List<Plant> viewPlantsBySpread(String plantSpread) throws PlantException {
		List<Plant> list = plantRepo.findByPlantSpread(plantSpread);
		if (list.isEmpty()) {
			throw new PlantException("There are no Plants with spread : " + plantSpread);
		}
		return list;
	}

	@Override
	public List<Plant> viewPlantsByTemperature(Double min, Double max) throws PlantException {
		List<Plant> list = plantRepo.findByTemperatureBetween(min, max);
		if (list.isEmpty()) {
			throw new PlantException("There are no Plants with temperature in this range.");
		}
		return list;
	}

	@Override
	public List<Plant> viewPlantsByCost(Double min, Double max) throws PlantException {
		List<Plant> list = plantRepo.findByPlantCostBetween(min, max);
		if (list.isEmpty()) {
			throw new PlantException("There are no Plants with price in this range.");
		}
		return list;
	}

}
