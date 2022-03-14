package com.inscompany.dtos;

import com.inscompany.model.Vehicle;

public class VehicleDto {

	private String license;
    private long numberOfDoors;
    private Vehicle.FuelType fuelType;
    private int power;
    
	public VehicleDto(String license) {
		super();
		this.license = license;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public long getNumberOfDoors() {
		return numberOfDoors;
	}
	public void setNumberOfDoors(long numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}
	public Vehicle.FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(Vehicle.FuelType fuelType) {
		this.fuelType = fuelType;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
    
    
}
