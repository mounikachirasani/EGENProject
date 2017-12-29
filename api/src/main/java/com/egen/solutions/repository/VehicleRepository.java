package com.egen.solutions.repository;

import com.egen.solutions.dataobject.Vehicle;

import java.util.List;

public interface VehicleRepository {


    public List<Vehicle> listAll();

    public Vehicle getById(String vehicleId);

    public Vehicle create(Vehicle vehicleObj);

    public Vehicle update(Vehicle vehicleObj);

    public void delete(Vehicle vehicleObj);

}
