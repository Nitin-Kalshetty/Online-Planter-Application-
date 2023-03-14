package com.rocker.services;

import java.util.List;

import com.rocker.exceptions.CustomerException;
import com.rocker.exceptions.SeedException;
import com.rocker.model.Seed;

public interface SeedService {

	public Seed addSeed(Seed seed) throws SeedException,CustomerException;
	
	public Seed updateSeed(Seed seed)throws SeedException,CustomerException;
	
	public Seed deleteSeed(Integer id)throws SeedException,CustomerException;
	
	public Seed viewSeed(Integer id)throws SeedException,CustomerException;
	
	public Seed viewSeed(String commanName)throws SeedException,CustomerException;
	
	public List<Seed> viewAllSeeds()throws SeedException,CustomerException;
	
	public List<Seed> viewAllSeeds(String typeOfSeed)throws SeedException,CustomerException;
}
