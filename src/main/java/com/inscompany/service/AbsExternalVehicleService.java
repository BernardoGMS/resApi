package com.inscompany.service;
import com.inscompany.dtos.VehicleDto;

public interface AbsExternalVehicleService {

	VehicleDto getVehicleInfoByLicense(String license) throws Exception;
	
	String getCountryFullNameByCodeISO3166(String code)  throws Exception;
}
