package com.rocker.services;

import java.util.List;

import com.rocker.exceptions.CustomerException;
import com.rocker.exceptions.SeedException;
import com.rocker.model.Seed;

public interface SeedService {

	public Seed addSeed(Seed seed) throws SeedException;
	
	public Seed updateSeed(Seed seed)throws SeedException;
	
	public Seed deleteSeed(Integer seedId)throws SeedException;
	
	public Seed viewSeedById(Integer seedId)throws SeedException;
	
	public List<Seed> viewSeedByCommonName(String name)throws SeedException;
	
	public List<Seed> viewAllSeeds()throws SeedException;
	
	public List<Seed> viewAllSeedsByType(String type)throws SeedException;
	
	public List<Seed> viewAllSeedsByTemperature(Double min,Double max)throws SeedException;
	
	public List<Seed> viewAllSeedsByCost(Double min,Double max)throws SeedException;
	
	public List<Seed> viewAllSeedsByPerPacket(Integer min,Integer max)throws SeedException;
}
