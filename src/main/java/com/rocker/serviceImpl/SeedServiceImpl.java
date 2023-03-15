package com.rocker.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rocker.exceptions.PlantException;
import com.rocker.exceptions.SeedException;
import com.rocker.model.Plant;
import com.rocker.model.Seed;
import com.rocker.repository.SeedRepository;
import com.rocker.services.SeedService;

@Service
public class SeedServiceImpl implements SeedService{
	
	@Autowired
	private SeedRepository seedRepo;

	@Override
	public Seed addSeed(Seed seed) throws SeedException {
		try {
			return seedRepo.save(seed);
		} catch (DataIntegrityViolationException e) {
			throw new SeedException("Already Seed exists please use Update to add");
		}
	}

	@Override
	public Seed updateSeed(Seed seed) throws SeedException {
		Optional<Seed> opt  = seedRepo.findById(seed.getSeedId());
		if(opt.isEmpty()) {
			throw new SeedException("There is no such seed please check");
		}
		Seed check = opt.get();
		UpdateValidator uv = new UpdateValidator();
		check.setBloomTime(uv.checker( seed.getBloomTime() ) ? seed.getBloomTime() : check.getBloomTime() );
		check.setCommonName(uv.checker( seed.getCommonName() ) ? seed.getCommonName() : check.getCommonName() );
		check.setDifficultyLevel(uv.checker( seed.getDifficultyLevel() ) ? seed.getDifficultyLevel() : check.getDifficultyLevel() );
		check.setSeedCost(uv.checker( seed.getSeedCost() ) ? seed.getSeedCost() : check.getSeedCost() );	
		check.setSeedDescription(uv.checker( seed.getSeedDescription() ) ? seed.getSeedDescription() : check.getSeedDescription() );
		check.setWatering(uv.checker( seed.getWatering() ) ? seed.getWatering() : check.getWatering() );
		check.setSeedsPerPacket(uv.checker( seed.getSeedsPerPacket() ) ? seed.getSeedsPerPacket() : check.getSeedsPerPacket());
		check.setSeedStock(uv.checker( seed.getSeedStock() ) ? seed.getSeedStock() : check.getSeedStock() );
		check.setTemperature(uv.checker( seed.getTemperature() ) ? seed.getTemperature() : check.getTemperature() );
		check.setTypeOfSeed(uv.checker( seed.getTypeOfSeed() ) ? seed.getTypeOfSeed() : check.getTypeOfSeed() );
		return seedRepo.save(check);
	}

	@Override
	public Seed deleteSeed(Integer seedId) throws SeedException {
		Optional<Seed> opt  = seedRepo.findById(seedId);
		if(opt.isEmpty()) {
			throw new SeedException("No Seed Found with ID : "+seedId);
		}
		Seed seed = opt.get();
		seedRepo.delete(seed);
		return seed;
	}

	@Override
	public Seed viewSeedById(Integer seedId) throws SeedException {
		Optional<Seed> opt  = seedRepo.findById(seedId);
		if(opt.isEmpty()) {
			throw new SeedException("No Seed Found with ID : "+seedId);
		}
		return opt.get();
	}

	@Override
	public List<Seed> viewSeedByCommonName(String name) throws SeedException {
		List<Seed> list =  seedRepo.findByCommonName(name);
		if(list.isEmpty()) {
			throw new SeedException("There are no Seed with name : "+name);
		}
		return list;
	}

	@Override
	public List<Seed> viewAllSeeds() throws SeedException {
		List<Seed> list =  seedRepo.findAll();
		if(list.isEmpty()) {
			throw new SeedException("There are no Seeds");
		}
		return list;
	}

	@Override
	public List<Seed> viewAllSeedsByType(String type) throws SeedException {
		List<Seed> list =  seedRepo.findByTypeOfSeed(type);
		if(list.isEmpty()) {
			throw new SeedException("There are no Seeds with type : "+type);
		}
		return list;
	}

	@Override
	public List<Seed> viewAllSeedsByTemperature(Double min, Double max) throws SeedException {
		List<Seed> list =  seedRepo.findByTemperatureBetween(min, max);
		if(list.isEmpty()) {
			throw new SeedException("There are no Seeds with temperature in this range.");
		}
		return list;
	}

	@Override
	public List<Seed> viewAllSeedsByCost(Double min, Double max) throws SeedException {
		List<Seed> list =  seedRepo.findBySeedCostBetween(min, max);
		if(list.isEmpty()) {
			throw new SeedException("There are no Seeds with price in this range.");
		}
		return list;
	}

	@Override
	public List<Seed> viewAllSeedsByPerPacket(Integer min, Integer max) throws SeedException {
		List<Seed> list =  seedRepo.findBySeedsPerPacketBetween(min, max);
		if(list.isEmpty()) {
			throw new SeedException("There are no Seeds within per packet range.");
		}
		return list;
	}

	

}
