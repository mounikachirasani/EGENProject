package com.egen.solutions.service.impl;

import com.egen.solutions.dataobject.Alert;
import com.egen.solutions.dataobject.Reading;
import com.egen.solutions.dataobject.Vehicle;
import com.egen.solutions.exception.BadRequestException;
import com.egen.solutions.exception.ResourceNotFoundException;
import com.egen.solutions.repository.VehicleAlertRepository;
import com.egen.solutions.repository.VehicleRepository;
import com.egen.solutions.service.ReadingService;
import com.egen.solutions.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ReadingService readingService;

    @Autowired
    VehicleAlertRepository vehicleAlertRepository;

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
            throw new BadRequestException("Vehicle with vin " +vehicleObj.getVin() +" already exists");
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
    @Transactional
    public List<Vehicle> upsert(List<Vehicle> vehicleObjs){
        for(Vehicle vehicle : vehicleObjs) {
            Vehicle existingVehicle = vehicleRepository.getById(vehicle.getVin());
            if (existingVehicle == null) {
                vehicleRepository.create(vehicle);
            } else {
                vehicleRepository.update(vehicle);
            }
        }
        return vehicleObjs;
    }

    @Transactional
    public void delete(String vehicleId) {
        Vehicle existingVehicle = vehicleRepository.getById(vehicleId);
        if (existingVehicle == null) {
            throw new ResourceNotFoundException("Vehicle with id " + vehicleId + " doesn't exist.");
        }
        vehicleRepository.delete(existingVehicle);
    }

    @Transactional
    public List<Alert> getVehicleAlertsByVin(String vehicleId) {
        return vehicleAlertRepository.getVehicleAlertsByVin(vehicleId);
    }

}
