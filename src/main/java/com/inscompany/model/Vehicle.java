package com.inscompany.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_VEHICLE")
public class Vehicle implements AbsVehicle, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(name = "LICENSE")
    private String license;
    @Column(name = "COUNTRY")
    private String countryOfLicense;
    @Column(name = "RISK_FACTOR")
    private double riskFactor;
    @Column(name = "N_DOORS")
    private long numberOfDoors;
    @Column(name = "FUEL_TYPE")
    private Vehicle.FuelType fuelType;
    @Column(name = "POWER")
    private int power;

    private String countryFullName;
    
    public enum FuelType {
        DIESEL("diesel"),
        LPG("lpg"),
        PETROL("petrol"),
        NATURALGAS("naturalgas"),
        ELECTRIC("electricity");

        private final String fuelType;

        FuelType(String fuelType) {
            this.fuelType = fuelType;
        }

        public String getFuelType() {
            return fuelType;
        }
    }

    public long getId() {
        return ID;
    }

    public String getLicense() {
        return license;
    }

    public String getCountryOfLicense() {
        return countryOfLicense;
    }

    public double getRiskFactor() {
        return riskFactor;
    }

    public long getNumberOfDoors() {
        return numberOfDoors;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getPower() {
        return power;
    }

    public void setId(long id) {
        this.ID = id;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setCountryOfLicense(String countryOfLicense) {
        this.countryOfLicense = countryOfLicense;
    }

    public void setRiskFactor(double riskFactor) {
        this.riskFactor = riskFactor;
    }

    public void setNumberOfDoors(long numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public void setPower(int power) {
        this.power = power;
    }
    
    public String getCountryFullName() {
		return countryFullName;
	}

	public void setCountryFullName(String countryFullName) {
		this.countryFullName = countryFullName;
	}

	@Override
    public String toString() {
        return "Vehicle{" +
                "id=" + ID +
                ", license='" + license + '\'' +
                ", countryOfLicense='" + countryOfLicense + '\'' +
                ", riskFactor=" + riskFactor +
                ", numberOfDoors=" + numberOfDoors +
                ", fuelType=" + fuelType +
                ", power=" + power +
                '}';
    }


}
