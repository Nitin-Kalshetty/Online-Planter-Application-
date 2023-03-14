package com.rocker.services;

import java.util.List;

import com.rocker.exceptions.CustomerException;
import com.rocker.exceptions.PlanterException;
import com.rocker.model.Planter;

public interface PlanterService {

public Planter addPlanter(Planter planter) throws PlanterException,CustomerException;
	
	public Planter updatePlanter(Planter planter) throws PlanterException,CustomerException;
	
	public Planter deletePlanter (Integer planterId) throws PlanterException,CustomerException;
	
	public Planter viewPlanter(Integer planterId) throws PlanterException,CustomerException;
	
	public List<Planter> viewPlanterByShape(String planterShape) throws PlanterException,CustomerException;
	
	public List<Planter> viewAllPlanters() throws PlanterException,CustomerException;
	
	public List<Planter> viewAllPlanters(Double minCost,Double maxCost) throws PlanterException,CustomerException;
}
