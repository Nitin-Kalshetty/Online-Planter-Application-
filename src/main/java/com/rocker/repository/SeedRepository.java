package com.rocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocker.model.Seed;

@Repository
public interface SeedRepository extends JpaRepository<Seed, Integer>{

}
