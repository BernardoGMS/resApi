package com.inscompany.service;

import com.inscompany.model.Vehicle;

import java.util.List;

public interface AbsVehicleService {

    public List<Vehicle> getAllVehicles();

    public Vehicle getById (Long id);

    public void saveOrUpdate(Vehicle vehicle);

    public void deleteVehicle(Long id);



}
