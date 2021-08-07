package com.cropbiddingsystem.application.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cropbiddingsystem.application.entity.Crop;
import com.cropbiddingsystem.application.exception.CropNotFoundException;
import com.cropbiddingsystem.application.exception.FarmerNotFoundException;



public interface ICropRepository extends JpaRepository<Crop, Integer> {

	
//	@Query("Select c from Crop c where c.cropId = :cropId ")
//	public Crop fetchCrop(int cropId) throws CropNotFoundException;
	
	@Query("Select c from Crop c where c.farmer.id = :farmerId")
	public List<Crop> getCropsByFarmer(int farmerId) throws FarmerNotFoundException;
	
	@Query("Select c from Crop c where c.cropName = :farmerName")
	public List<Crop> getCropsByName(String farmerName);
	
	@Query("Select c from Crop c where c.isApproved = :approval")
	public List<Crop> fetchCropByStatus(boolean approval);

}
