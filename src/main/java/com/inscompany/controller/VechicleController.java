package com.inscompany.controller;

import com.inscompany.model.AbsVehicle;
import com.inscompany.model.Vehicle;
import com.inscompany.service.VehicleService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api_REST")
public class VechicleController {

    @Autowired
    VehicleService service;

    @PostMapping("/save")
    public Vehicle save(@RequestBody Vehicle vehicle){
        service.saveOrUpdate(vehicle);
        return vehicle;
    }
    
    @GetMapping("/vehicle/{id}")
    public ResponseEntity<AbsVehicle> getVehicleById(@PathVariable Long id){
 
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
 
    	ResponseEntity<List<Vehicle>> response = new ResponseEntity<List<Vehicle>>(HttpStatus.OK);
    	
    	//find and set all the country full names
    	for (Vehicle vehicle : response.getBody()) {
			vehicle.setCountryFullName(vehicle.getCountryOfLicense());
		}
    	
        return response;
    }
   
    
}
