package com.rocker.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rocker.exceptions.CustomerException;
import com.rocker.exceptions.SeedException;
import com.rocker.model.Seed;
import com.rocker.services.SeedService;

@Service
public class SeedServiceImpl implements SeedService{

	@Override
	public Seed addSeed(Seed seed) throws SeedException, CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seed updateSeed(Seed seed) throws SeedException, CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seed deleteSeed(Integer id) throws SeedException, CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seed viewSeed(Integer id) throws SeedException, CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seed viewSeed(String commanName) throws SeedException, CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seed> viewAllSeeds() throws SeedException, CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed) throws SeedException, CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
