package com.rocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocker.model.Planter;


@Repository
public interface PlanterRepository extends JpaRepository<Planter, Integer>{
		public List<Planter> findByPlanterShape(String planterShape);
		public List<Planter> findByPlanterColor(String planterColor);
		public List<Planter> findByPlanterCostBetween(Double min,Double max);
		public List<Planter> findByPlanterheightBetween(Double min,Double max);
		public List<Planter> findByPlanterCapacityBetween(Double min,Double max);
		public List<Planter> findByDrainageHolesBetween(Integer min,Integer max);
}



