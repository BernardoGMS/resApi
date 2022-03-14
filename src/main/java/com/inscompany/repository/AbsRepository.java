package com.inscompany.repository;

import com.inscompany.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface AbsRepository extends CrudRepository<Vehicle, Long> {
}
