package com.inscompany.service;

import com.inscompany.model.Vehicle;
import com.inscompany.repository.AbsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VehicleService implements AbsVehicleService{

    @Autowired
    AbsRepository repository;

    @Override
    public List<Vehicle> getAllVehicles() {
        return (List<Vehicle>) repository.findAll();
    }

    @Override
    public Vehicle getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Vehicle vehicle) {
         repository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        repository.deleteById(id);
    }
}
