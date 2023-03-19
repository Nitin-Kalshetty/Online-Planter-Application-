package com.rocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocker.model.Seed;

@Repository
public interface SeedRepository extends JpaRepository<Seed,Integer> {

	public List<Seed> findByCommonName(String commonName);

	public List<Seed> findByTemperatureBetween(Double min, Double max);

	public List<Seed> findByTypeOfSeed(String typeOfPlant);

	public List<Seed> findBySeedCostBetween(Double min, Double max);

	public List<Seed> findBySeedsPerPacketBetween(Integer min, Integer max);

}
