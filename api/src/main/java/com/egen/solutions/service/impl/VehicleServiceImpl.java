package com.egen.solutions.service.impl;

import com.egen.solutions.dataobject.Vehicle;
import com.egen.solutions.exception.ResourceNotFoundException;
import com.egen.solutions.repository.VehicleRepository;
import com.egen.solutions.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public List<Vehicle> listAll() {
        return vehicleRepository.listAll();
    }

    public Vehicle getById(String vehicleId) {
        Vehicle existingVehicle = vehicleRepository.getById(vehicleId);
        if(existingVehicle == null)
        {
            throw new ResourceNotFoundException("Vehicle with id " + vehicleId + " doesn't exist.");
        }
        return existingVehicle;
    }

    @Transactional
    public Vehicle create(Vehicle vehicleObj) {
        Vehicle exists = vehicleRepository.getById(vehicleObj.getVin());
        if (exists == null) {
            return vehicleRepository.create(vehicleObj);
        }else{
            throw new RuntimeException("Record already exists");
        }
    }

    @Transactional
    public Vehicle update(String vehicleId, Vehicle vehicleObj) {
        Vehicle existingVehicle = vehicleRepository.getById(vehicleId);
        if (existingVehicle == null) {
            throw new ResourceNotFoundException("Vehicle with id " + vehicleId + " doesn't exist.");
        }
        return vehicleRepository.update(vehicleObj);
    }

    public List<Vehicle> upsert(List<Vehicle> vehicleObjs){
        for(Vehicle vehicle : vehicleObjs) {
            Vehicle existingVehicle = vehicleRepository.getById(vehicle.getVin());
            if (existingVehicle == null) {
                vehicleRepository.create(vehicle);
            } else {
                vehicleRepository.update(vehicle);
            }
        }
        return vehicleRepository.listAll();
    }

    @Transactional
    public void delete(String vehicleId) {
        Vehicle existingVehicle = vehicleRepository.getById(vehicleId);
        if (existingVehicle == null) {
            throw new ResourceNotFoundException("Vehicle with id " + vehicleId + " doesn't exist.");
        }
        vehicleRepository.delete(existingVehicle);
    }

}
