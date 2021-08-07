package com.cropbiddingsystem.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropbiddingsystem.application.entity.Crop;
import com.cropbiddingsystem.application.exception.CropNotFoundException;
import com.cropbiddingsystem.application.exception.FarmerNotFoundException;
import com.cropbiddingsystem.application.repository.ICropRepository;


@Service("icropservice")
public class ICropServiceImpl implements ICropService  {

	@Autowired
	ICropRepository repository;
	
	@Override
	public Crop addCrop(Crop crop) {
	
		Crop crp = repository.save(crop);
		return crp;
		
	}

	@Override
	public Crop editCrop(Crop crop) {
		Crop crp = repository.save(crop);
		return crp;
	}

	@Override
	public Optional<Crop> getCrop(int cropId) throws CropNotFoundException {
		Optional<Crop> crp= repository.findById(cropId);
		if(!crp.equals(null)) 
			return crp;
		else
			throw new CropNotFoundException("No Crop Found");
		
	}

	@Override
	public List<Crop> getAllCrops() {
		List<Crop> crop = repository.findAll(); 
		return crop;
	}

	@Override
	public List<Crop> getCropsByFarmer(int farmerId) throws FarmerNotFoundException {
		List<Crop> crop = repository.getCropsByFarmer(farmerId);
		if(!crop.isEmpty())
			return crop;
		else
			throw new FarmerNotFoundException("No Crops by the farmer found");
			
		
	}

	@Override
	public List<Crop> getCropsByName(String name) {
		List<Crop> crop = repository.getCropsByName(name);
		return crop;
	}

	@Override
	public List<Crop> getCropByStatus(boolean approval) {
		List<Crop> crop = repository.fetchCropByStatus(approval);
		return crop;
	}

	
}
