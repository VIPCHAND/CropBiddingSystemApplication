package com.cropbiddingsystem.application.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;



@Entity
@Table(name= "crop")
public class Crop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cropId;
	private String cropName;	// Wheat/Rice/Cotton/Lentils/Sugarcane
	private String cropType;	// Kharif/Rabi/Zaid
	private String fertilizer;	// Nitrogen based/Phosphorus based and Complex
	private double quantity;	// Tons/Kgs
	private double basePrice;	
	private boolean isApproved;	
//	@OneToMany(mappedBy = "crop", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
//	private List<Bid> bids;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="farmer_id")
	private Farmer farmer;
	
	
//	public List<Bid> getBids() {
//		return bids;
//	}
//	public void setBids(List<Bid> bids) {
//		this.bids = bids;
//	}
	public Crop() {
		// TODO Auto-generated constructor stub
	}
	public int getCropId() {
		return cropId;
	}
	public void setCropId(int cropId) {
		this.cropId = cropId;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public String getFertilizer() {
		return fertilizer;
	}
	public void setFertilizer(String fertilizer) {
		this.fertilizer = fertilizer;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public Farmer getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
}

	
	

