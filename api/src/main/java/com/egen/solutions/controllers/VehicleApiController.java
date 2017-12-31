package com.egen.solutions.controllers;

import com.egen.solutions.dataobject.Alert;
import com.egen.solutions.dataobject.Vehicle;
import com.egen.solutions.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/vehicles")
public class VehicleApiController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> listAll() {
        return vehicleService.listAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Vehicle getById(@PathVariable("id") String vehicleId) {
        return vehicleService.getById(vehicleId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Vehicle create(@RequestBody Vehicle vehicleObj) {
        return vehicleService.create(vehicleObj);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Vehicle update(@PathVariable("id") String vehicleId, @RequestBody Vehicle vehicleObj) {
        return vehicleService.update(vehicleId, vehicleObj);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicle> upsert(@RequestBody List<Vehicle> vehicleObjs){
        return vehicleService.upsert(vehicleObjs);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") String vehicleId) {
        vehicleService.delete(vehicleId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/alerts")
    public List<Alert> getVehicleAlertsByVin(@PathVariable("id") String vehicleId) {
        return vehicleService.getVehicleAlertsByVin(vehicleId);
    }
}
