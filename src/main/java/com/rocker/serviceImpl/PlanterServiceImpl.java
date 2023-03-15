package com.rocker.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rocker.exceptions.PlanterException;
import com.rocker.model.Planter;
import com.rocker.repository.PlanterRepository;
import com.rocker.services.PlanterService;

@Service
public class PlanterServiceImpl implements PlanterService{
	
	
	@Autowired
	private PlanterRepository planterRepo;

	@Override
	public Planter addPlanter(Planter planter) throws PlanterException {
//		Planter check = null;
//		try {
//			check = planterRepo.save(planter);
//		} catch (DataIntegrityViolationException e) {
//			throw new PlanterException("Already planter exists please use Update to add");
//		}
//		return check;
		

		try {
			return planterRepo.save(planter);
		} catch (DataIntegrityViolationException e) {
			throw new PlanterException("Already planter exists please use Update to add");
		}

		
		
	}

	@Override
	public Planter updatePlanter(Planter planter) throws PlanterException {
		Optional<Planter> opt  = planterRepo.findById(planter.getPlanterId());
		if(opt.isEmpty()) {
			throw new PlanterException("There is no such planter please check");
		}
		Planter check = opt.get();
		UpdateValidator uv = new UpdateValidator();
		check.setDrainageHoles(uv.checker(planter.getDrainageHoles()) ? planter.getDrainageHoles() : check.getDrainageHoles());
		check.setPlanterCapacity(uv.checker(planter.getPlanterCapacity()) ? planter.getPlanterCapacity() : check.getPlanterCapacity());
		check.setPlanterColor(uv.checker(planter.getPlanterColor()) ? planter.getPlanterColor() : check.getPlanterColor());
		check.setPlanterCost(uv.checker(planter.getPlanterCost()) ? planter.getPlanterCost() : check.getPlanterCost());
		check.setPlanterheight(uv.checker(planter.getPlanterheight()) ? planter.getPlanterheight() : check.getPlanterheight());
		check.setPlanterShape(uv.checker(planter.getPlanterShape()) ? planter.getPlanterShape() : check.getPlanterShape());
		check.setPlanterStock(uv.checker(planter.getPlanterStock()) ? planter.getPlanterStock() : check.getPlanterStock());
		
		return planterRepo.save(check);
	}
	


	@Override
	public Planter deletePlanter(Integer planterId) throws PlanterException {
		Optional<Planter> opt  = planterRepo.findById(planterId);
		if(opt.isEmpty()) {
			throw new PlanterException("No Planter Found with ID : "+planterId);
		}
		Planter planter = opt.get();
		planterRepo.delete(planter);
		return planter;
	}

	@Override
	public Planter viewPlanterById(Integer planterId) throws PlanterException{
		Optional<Planter> opt  = planterRepo.findById(planterId);
		if(opt.isEmpty()) {
			throw new PlanterException("No Planter Found with ID : "+planterId);
		}
		return opt.get();
	}

	@Override
	public List<Planter> viewPlanterByShape(String planterShape) throws PlanterException {
		List<Planter> list =  planterRepo.findByPlanterShape(planterShape);
		if(list.isEmpty()) {
			throw new PlanterException("There are no Planters with shape "+planterShape);
		}
		return list;
	}

	@Override
	public List<Planter> viewAllPlanters() throws PlanterException {
		List<Planter> list =  planterRepo.findAll();
		if(list.isEmpty()) {
			throw new PlanterException("There are no Planters");
		}
		return list;
	}

	@Override
	public List<Planter> viewPlantersByCostRange(Double minCost, Double maxCost) throws PlanterException {
		List<Planter> list = planterRepo.findByPlanterCostBetween(minCost, maxCost);
		if(list.isEmpty()) {
			throw new PlanterException("There are no Planters");
		}
		return list;
	}

	@Override
	public List<Planter> viewPlanterByColor(String planterColor) throws PlanterException {
		List<Planter> list =  planterRepo.findByPlanterColor(planterColor);
		if(list.isEmpty()) {
			throw new PlanterException("There are no Planters with color "+planterColor);
		}
		return list;
	}

	@Override
	public List<Planter> viewPlantersByCapacityRange(Double minC, Double maxC) throws PlanterException {
		List<Planter> list = planterRepo.findByPlanterCapacityBetween(minC, maxC);
		if(list.isEmpty()) {
			throw new PlanterException("There are no Planters");
		}
		return list;
	}

	@Override
	public List<Planter> viewPlantersByHeightRange(Double minH, Double maxH) throws PlanterException {
		List<Planter> list = planterRepo.findByPlanterheightBetween(minH, maxH);
		if(list.isEmpty()) {
			throw new PlanterException("There are no Planters");
		}
		return list;
	}

	@Override
	public List<Planter> viewPlantersByHolesRange(Integer minHole, Integer maxHole) throws PlanterException {
		List<Planter> list = planterRepo.findByDrainageHolesBetween(minHole, maxHole);
		if(list.isEmpty()) {
			throw new PlanterException("There are no Planters");
		}
		return list;
	}

}
