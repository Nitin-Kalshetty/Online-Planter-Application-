package com.rocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocker.model.Overall;

@Repository
public interface OverallRepository extends JpaRepository<Overall, Integer> {

}
