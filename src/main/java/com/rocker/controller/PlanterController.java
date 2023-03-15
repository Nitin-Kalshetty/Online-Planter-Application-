package com.rocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rocker.model.Plant;
import com.rocker.model.Planter;
import com.rocker.services.PlanterService;

@RestController
public class PlanterController {

	@Autowired
	private PlanterService planterService;
	
	@PostMapping("/planter")
	public ResponseEntity<Planter> addPlanterHandler(@RequestBody Planter planter){
		return new ResponseEntity<>(planterService.addPlanter(planter),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/planter")
	public ResponseEntity<Planter> updatePlanterHandler(@RequestBody Planter planter){
		return new ResponseEntity<>(planterService.updatePlanter(planter),HttpStatus.OK);
	}
	
	@DeleteMapping("/planter")
	public ResponseEntity<Planter> deletePlanterHandler(@RequestParam Integer planterId){
		return new ResponseEntity<>(planterService.deletePlanter(planterId),HttpStatus.OK);
	}
	@GetMapping("/planterById")
	public ResponseEntity<Planter> viewPlanterByIdHandler(@RequestParam Integer planterId){
		return new ResponseEntity<>(planterService.viewPlanterById(planterId),HttpStatus.OK);
	}
	@GetMapping("/planters")
	public ResponseEntity<List<Planter>> viewAllPlantersHandler(){
		return new ResponseEntity<>(planterService.viewAllPlanters(),HttpStatus.OK);
	}
	@GetMapping("/plantersByCapacity")
	public ResponseEntity<List<Planter>> viewPlantersByCapacityHandler(@RequestParam Double capacityMin,@RequestParam Double capacityMax){
		return new ResponseEntity<>(planterService.viewPlantersByCapacityRange(capacityMin, capacityMax),HttpStatus.OK);
	}
	
	@GetMapping("/plantersByHeight")
	public ResponseEntity<List<Planter>> viewPlantersByHeightHandler(@RequestParam Double heightMin,@RequestParam Double heightMax){
		return new ResponseEntity<>(planterService.viewPlantersByHeightRange(heightMin, heightMax),HttpStatus.OK);
	}
	
	@GetMapping("/plantersByCost")
	public ResponseEntity<List<Planter>> viewPlantersByCostHandler(@RequestParam Double costMin,@RequestParam Double costMax){
		return new ResponseEntity<>(planterService.viewPlantersByCostRange(costMin, costMax),HttpStatus.OK);
	}
	
	@GetMapping("/plantersByHoles")
	public ResponseEntity<List<Planter>> viewPlantersByHolesHandler(@RequestParam Integer holesMin,@RequestParam Integer holesMax){
		return new ResponseEntity<>(planterService.viewPlantersByHolesRange(holesMin, holesMax),HttpStatus.OK);
	}
}
