package com.cropbiddingsystem.application.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cropbiddingsystem.application.entity.Crop;
import com.cropbiddingsystem.application.exception.CropNotFoundException;
import com.cropbiddingsystem.application.exception.FarmerNotFoundException;
import com.cropbiddingsystem.application.service.ICropService;


@RestController
@RequestMapping("/cropBiddingApplication")
public class CropController {

	//   http://localhost:8586/cropBiddingApplication/addCrop
	
	@Autowired
	ICropService service;
	
	@PostMapping("/addCrop")
	public ResponseEntity<String> CropInsert(@RequestBody Crop crop){
		
		service.addCrop(crop);
		return new ResponseEntity<String>("Crop Added Successfully",new HttpHeaders(),HttpStatus.OK);
	}
	//     http://localhost:8586/cropBiddingApplication/editCrop
	@PutMapping("/editCrop")
	public ResponseEntity<String> EditCrop(@RequestBody Crop crop){
		service.editCrop(crop);
		return new ResponseEntity<String>("Crop Updated Succesfully",new HttpHeaders(),HttpStatus.OK);
	}
    //  http://localhost:8586/cropBiddingApplication/fetchCrop/{id}
	@GetMapping("/fetchCrop/{id}")
	public Crop fetchCrop(@PathVariable("id") int id) throws CropNotFoundException {
		Optional<Crop> crop  = service.getCrop(id);
		if(crop.isPresent())
			return crop.get();
		
		else
			throw new CropNotFoundException("Crop Not Found");
				
	}
    //  http://localhost:8586/cropBiddingApplication/fetchAllCrop
	@GetMapping("/fetchAllCrops")
	private ResponseEntity<List<Crop>> fetchAllCrops(){
		List<Crop> crop = service.getAllCrops();
		return new ResponseEntity<List<Crop>>(crop,new HttpHeaders(),HttpStatus.OK);
	}
	// http://localhost:8586/cropBiddingApplication/fetchCropByFarmer/{farmerId}
	@GetMapping("/fetchCropByFarmer/{farmerId}")
	private ResponseEntity<List<Crop>> fetchCropsByFarmer(@PathVariable("farmerId") int farmerId ) throws FarmerNotFoundException{
		List<Crop> crop = service.getCropsByFarmer(farmerId);
		if(!crop.isEmpty()) 
			return new ResponseEntity<List<Crop>>(crop,new HttpHeaders(),HttpStatus.OK);
		else
			throw new FarmerNotFoundException("No Crops By this Farmer Found");	
	}
	// http://localhost:8586/cropBiddingApplication/fetchCropsByName/{farmername}
	@GetMapping("/fetchCropsByName/{farmername}")
	private List<Crop> fetchCropsByName(@PathVariable("farmername") String farmername){
		List<Crop> crop = service.getCropsByName(farmername);
		
			return (List<Crop>) new ResponseEntity<List<Crop>>(crop,new HttpHeaders(),HttpStatus.OK);
		
	}
	// http://localhost:8586/cropBiddingApplication/fetchCropsByStatus/{status}
	@GetMapping("/fetchCropsByStatus/{status}")
	private List<Crop> fetchCropsByStatus(@PathVariable("status") boolean status ){
		List<Crop> crop = service.getCropByStatus(status);
		
			return (List<Crop>) new ResponseEntity<List<Crop>>(crop,new HttpHeaders(),HttpStatus.OK);
	}
	
	
}
