package com.egen.solutions.service;

import com.egen.solutions.dataobject.Alert;
import com.egen.solutions.dataobject.Vehicle;

import java.util.List;


public interface VehicleService {

    List<Vehicle> listAll();

    Vehicle getById(String vehicleId);

    Vehicle create(Vehicle vehicleObj);

    Vehicle update(String vehicleId, Vehicle vehicleObj);

    List<Vehicle> upsert(List<Vehicle> vehicleObjs);

    void delete(String vehicleId);

    List<Alert> getVehicleAlertsByVin(String vehicleId);

}
