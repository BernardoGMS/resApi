package com.inscompany.springbootrestapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.ws.rs.GET;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.inscompany.model.Vehicle;
import com.inscompany.service.AbsExternalVehicleService;
import com.inscompany.service.ExternalVehicleService;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehicleControllerIntegrationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void createVehicleTest() throws Exception {
		
		AbsExternalVehicleService extService = new ExternalVehicleService();
		String license = "AB 00 CC";
		String countryCode = "FR";
		
		Vehicle vehicle = new Vehicle();
		vehicle.setLicense(license);
		vehicle.setCountryOfLicense(countryCode);
		vehicle.setCountryFullName(extService.getCountryFullNameByCodeISO3166(countryCode));
		vehicle.setRiskFactor(4);
		vehicle.setFuelType(extService.getVehicleInfoByLicense(license).getFuelType());
		vehicle.setNumberOfDoors(extService.getVehicleInfoByLicense(license).getNumberOfDoors());
		vehicle.setPower(extService.getVehicleInfoByLicense(license).getPower());
		
		HttpEntity<Vehicle> resquest = new HttpEntity<>(vehicle);
		
		ResponseEntity<Vehicle> response = testRestTemplate.postForEntity("/vehicle/fruits", resquest, Vehicle.class);
		
		assertNotNull(response.getBody().getId());
		assertEquals("AB 00 CC", response.getBody().getLicense());
		assertEquals("FR", response.getBody().getCountryOfLicense());
		assertEquals(4, response.getBody().getRiskFactor());
		assertEquals(Vehicle.FuelType.DIESEL.toString(), response.getBody().getFuelType());
		assertEquals(4, response.getBody().getNumberOfDoors());
		assertEquals(255, response.getBody().getPower());
	}
	
	@Test
	public void updateVehicleTest() throws Exception {
		
		AbsExternalVehicleService extService = new ExternalVehicleService();
		String license = "AB 00 CC";
		String countryCode = "FR";
		
		Vehicle vehicle = new Vehicle();
		vehicle.setId(4);
		vehicle.setLicense(license);
		vehicle.setCountryOfLicense(countryCode);
		vehicle.setCountryFullName(extService.getCountryFullNameByCodeISO3166(countryCode));
		vehicle.setRiskFactor(1);
		vehicle.setFuelType(extService.getVehicleInfoByLicense(license).getFuelType());
		vehicle.setNumberOfDoors(extService.getVehicleInfoByLicense(license).getNumberOfDoors());
		vehicle.setPower(extService.getVehicleInfoByLicense(license).getPower());
		
		HttpEntity<Vehicle> resquest = new HttpEntity<>(vehicle);
		
		ResponseEntity<Vehicle> response = testRestTemplate.postForEntity("/vehicle", resquest, Vehicle.class);
		
		assertNotNull(response.getBody().getId());
		assertEquals("AB 00 CC", response.getBody().getLicense());
		assertEquals("FR", response.getBody().getCountryOfLicense());
		assertEquals(3.4, response.getBody().getRiskFactor());
		assertEquals(Vehicle.FuelType.DIESEL.toString(), response.getBody().getFuelType());
		assertEquals(4, response.getBody().getNumberOfDoors());
		assertEquals(255, response.getBody().getPower());
	}
	
	@Test
	@Sql("/api-test.sql")
	public void getVehicleByIdTest() {
		
		int testId = 10;
 
		ResponseEntity<Vehicle> response = testRestTemplate.getForEntity("/vehicle/"+testId, Vehicle.class);

        assertEquals(testId,response.getBody().getId());
	}	
	
	@Test
	public void getAllVehiclesTest() {
	
		ResponseEntity<List<Vehicle>> response = testRestTemplate.exchange("/all", HttpMethod.GET, null, new ParameterizedTypeReference<List<Vehicle>>() {});

        assertEquals(response.getBody().size(), 6);
	}	
	
	@After
	@Sql("/truncate_table.sql")
	public void cleanDB() {
		
	}
	
}
