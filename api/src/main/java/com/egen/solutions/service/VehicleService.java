package com.egen.solutions.service;

import com.egen.solutions.dataobject.Vehicle;

import java.util.List;


public interface VehicleService {

    List<Vehicle> listAll();

    Vehicle getById(String vehicleId);

    Vehicle create(Vehicle vehicleObj);

    Vehicle update(String vehicleId, Vehicle vehicleObj);

    void delete(String vehicleId);

}
