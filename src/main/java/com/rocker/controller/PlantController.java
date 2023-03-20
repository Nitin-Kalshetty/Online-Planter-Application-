package com.rocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rocker.model.Plant;
import com.rocker.services.PlantService;

@RestController
public class PlantController {

	@Autowired
	private PlantService plantService;

	@PostMapping("/plant")
	public ResponseEntity<Plant> addPlantHandler(@RequestBody Plant plant) {
		return new ResponseEntity<>(plantService.addPlant(plant), HttpStatus.ACCEPTED);
	}

	@PutMapping("/plant")
	public ResponseEntity<Plant> updatePlantHandler(@RequestBody Plant plant) {
		return new ResponseEntity<>(plantService.updatePlant(plant), HttpStatus.OK);
	}

	@DeleteMapping("/plant")
	public ResponseEntity<Plant> deletePlantHandler(@RequestParam Integer plantId) {
		return new ResponseEntity<>(plantService.deletePlantById(plantId), HttpStatus.OK);
	}

	@GetMapping("/plantById")
	public ResponseEntity<Plant> viewPlanterByIdHandler(@RequestParam Integer plantId) {
		return new ResponseEntity<>(plantService.viewPlantById(plantId), HttpStatus.OK);
	}

	@GetMapping("/plants")
	public ResponseEntity<List<Plant>> viewAllPlantsHandler() {
		return new ResponseEntity<>(plantService.viewAllPlants(), HttpStatus.OK);
	}

	@GetMapping("/plantsByName")
	public ResponseEntity<List<Plant>> viewPlantsByNameHandler(@RequestParam String name) {
		return new ResponseEntity<>(plantService.viewPlantsByName(name), HttpStatus.OK);
	}

	@GetMapping("/plantsByType")
	public ResponseEntity<List<Plant>> viewPlantsByPlantTypeHandler(@RequestParam String type) {
		return new ResponseEntity<>(plantService.viewPlantsByPlantType(type), HttpStatus.OK);
	}

	@GetMapping("/plantsByHeight")
	public ResponseEntity<List<Plant>> viewPlantsByHeightHandler(@RequestParam Double min, @RequestParam Double max) {
		return new ResponseEntity<>(plantService.viewPlantsByHeight(min, max), HttpStatus.OK);
	}

	@GetMapping("/plantsBySpread")
	public ResponseEntity<List<Plant>> viewPlantsBySpreadHandler(@RequestParam String plantSpread) {
		return new ResponseEntity<>(plantService.viewPlantsBySpread(plantSpread), HttpStatus.OK);
	}

	@GetMapping("/plantsByTemperature")
	public ResponseEntity<List<Plant>> viewPlantsByTemperatureHandler(@RequestParam Double min,
			@RequestParam Double max) {
		return new ResponseEntity<>(plantService.viewPlantsByTemperature(min, max), HttpStatus.OK);
	}

	@GetMapping("/plantsByCost")
	public ResponseEntity<List<Plant>> viewPlantsByCostHandler(@RequestParam Double min, @RequestParam Double max) {
		return new ResponseEntity<>(plantService.viewPlantsByCost(min, max), HttpStatus.OK);
	}
}
