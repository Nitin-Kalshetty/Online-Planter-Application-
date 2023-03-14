package com.rocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocker.model.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer>{

}
