package com.cropbiddingsystem.application.service;

import java.util.List;
import java.util.Optional;

import com.cropbiddingsystem.application.entity.Crop;
import com.cropbiddingsystem.application.exception.CropNotFoundException;
import com.cropbiddingsystem.application.exception.FarmerNotFoundException;

public interface ICropService {

	public Crop addCrop(Crop crop);

	public Crop editCrop(Crop crop);

	public Optional<Crop>  getCrop(int cropId) throws CropNotFoundException;

	public List<Crop> getAllCrops();

	public List<Crop> getCropsByFarmer(int farmerId) throws FarmerNotFoundException;

	public List<Crop> getCropsByName(String name);

	public List<Crop> getCropByStatus(boolean approval);

}
