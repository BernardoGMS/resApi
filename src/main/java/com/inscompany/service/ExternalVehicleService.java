package com.inscompany.service;

import com.inscompany.dtos.VehicleDto;
import com.inscompany.model.Vehicle;

//Fake class just to simulate an external services
public class ExternalVehicleService implements AbsExternalVehicleService{

	@Override
	public VehicleDto getVehicleInfoByLicense(String license) throws Exception {
	
		if (license==null) {
			throw new Exception("License must not be null!");
		}
		
		VehicleDto dto = new VehicleDto(license);
		
		//Simulation of Ext Service with ifs
		if(license.equals("AA 00 AA")){
			
			dto.setFuelType(Vehicle.FuelType.ELECTRIC);
			dto.setNumberOfDoors(3);
			dto.setPower(550);
		}
		
		if(license.equals("AB 00 CC")){
			
			dto.setFuelType(Vehicle.FuelType.ELECTRIC);
			dto.setNumberOfDoors(4);
			dto.setPower(255);
		}
		
		if(license.equals("AA ZZ AA")){
			
			dto.setFuelType(Vehicle.FuelType.LPG);
			dto.setNumberOfDoors(2);
			dto.setPower(548);
		}else {
			
			// just to not leave those mandatory properties empty
			dto.setFuelType(Vehicle.FuelType.NATURALGAS);
			dto.setNumberOfDoors(4);
			dto.setPower(333);
		}
		
		return dto;
	}

	@Override
	public String getCountryFullNameByCodeISO3166(String code) throws Exception {
		
		//there are several apis that could give us that information, as https://restcountries.com/
		
			if (code==null) {
				throw new Exception("Code must not be null!");
			}
		
			if(code.equals("PT")){
				return "Portugal";
			}
			
			if(code.equals("FR")){
				return "France";
			}
			
			if(code.equals("GE")){
				return "Germany";
			}else {
				
				return "Unknown";
			}
		
	}

}
