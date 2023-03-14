package com.rocker.services;

import java.util.List;

import com.rocker.exceptions.CustomerException;
import com.rocker.exceptions.PlanterException;
import com.rocker.model.Planter;

public interface PlanterService {

public Planter addPlanter(Planter planter) throws PlanterException;
	
	public Planter updatePlanter(Planter planter) throws PlanterException;
	
	public Planter deletePlanter (Integer planterId) throws PlanterException;
	
	public Planter viewPlanterById(Integer planterId) throws PlanterException;
	
	public List<Planter> viewPlanterByShape(String planterShape) throws PlanterException;
	
	public List<Planter> viewPlanterByColor(String planterColor) throws PlanterException;
	
	public List<Planter> viewAllPlanters() throws PlanterException;
	
	public List<Planter> viewPlantersByCostRange(Double minCost,Double maxCost) throws PlanterException;
	
	public List<Planter> viewPlantersByCapacityRange(Double minC,Double maxC) throws PlanterException;
	
	public List<Planter> viewPlantersByHeightRange(Double minH,Double maxH) throws PlanterException;
	
	public List<Planter> viewPlantersByHolesRange(Integer minHole,Integer maxHole) throws PlanterException;
	
	
}
