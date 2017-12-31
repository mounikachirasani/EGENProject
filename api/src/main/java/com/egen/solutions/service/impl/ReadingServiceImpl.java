package com.egen.solutions.service.impl;

import com.egen.solutions.dataobject.Alert;
import com.egen.solutions.dataobject.AlertPriority;
import com.egen.solutions.dataobject.Reading;
import com.egen.solutions.dataobject.Vehicle;
import com.egen.solutions.exception.ResourceNotFoundException;
import com.egen.solutions.repository.ReadingRepository;
import com.egen.solutions.repository.VehicleAlertRepository;
import com.egen.solutions.repository.VehicleRepository;
import com.egen.solutions.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService {


    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    VehicleRepository vechicleRepository;

    @Autowired
    VehicleAlertRepository vechicleAlertRepository;

    public List<Reading> listAll() {
        return readingRepository.listAll();
    }

    public Reading getById(String readingId) {
        Reading existingReading = readingRepository.getById(readingId);
        if(existingReading == null)
        {
            throw new ResourceNotFoundException("Reading with id " + readingId + " doesn't exist.");
        }
        return existingReading;
    }

    @Transactional
    public Reading create(Reading readingObj) {
        if (readingObj != null && readingObj.getVin() != null) {
            Vehicle existingVehicle = vechicleRepository.getById(readingObj.getVin());
            if (existingVehicle != null) {
                validateVehicleReadingswithAlerts(readingObj, existingVehicle);
                readingRepository.create(readingObj);
            }else{
                throw new ResourceNotFoundException("Vehicle with vin " + readingObj.getVin() + " doesn't exist.");
            }
        }
        return readingObj;
    }

    @Transactional
    public Reading update(String readingId, Reading readingObj) {
        Reading existingReading = readingRepository.getById(readingId);
        if (existingReading == null) {
            throw new ResourceNotFoundException("Reading with id " + readingId + " doesn't exist.");
        }
        return readingRepository.update(readingObj);
    }

    @Transactional
    public void delete(String readingId) {
        Reading existingReading = readingRepository.getById(readingId);
        if (existingReading == null) {
            throw new ResourceNotFoundException("Reading with id " + readingId + " doesn't exist.");
        }
        readingRepository.delete(existingReading);
    }

    private void createVehicleAlert(AlertPriority alertPriority, String alertMessage, Vehicle existingVehicle){
        Alert alert= new Alert();
        alert.setAlertPriority(alertPriority);
        alert.setAlertMessage(alertMessage);
        alert.setVehicle(existingVehicle);
        vechicleAlertRepository.create(alert);
    }

    private void validateVehicleReadingswithAlerts(Reading readingObj, Vehicle existingVehicle) {

        if (readingObj.getEngineCoolantLow()) {
            createVehicleAlert(AlertPriority.MEDIUM, "Engine coolant is low", existingVehicle);
        }
        if (readingObj.getCheckEngineLightOn()) {
            createVehicleAlert(AlertPriority.URGENT, "Engine Light is on, take to the service", existingVehicle);
        }
        if (readingObj.getFuelVolume() < (0.1 * existingVehicle.getMaxFuelVolume())) {
            createVehicleAlert(AlertPriority.MEDIUM, "Vehicle Fuel is low", existingVehicle);
        }
        if (readingObj.getTires().getFrontLeft() < 32 || readingObj.getTires().getFrontRight() < 32 ||
                readingObj.getTires().getRearLeft() < 32 || readingObj.getTires().getRearRight() < 32) {
            createVehicleAlert(AlertPriority.LOW, "Tire pressure is low than minimum level", existingVehicle);
        }
        if (readingObj.getTires().getFrontLeft() > 36 || readingObj.getTires().getFrontRight() < 36 ||
                readingObj.getTires().getRearLeft() < 36 || readingObj.getTires().getRearRight() < 36) {
            createVehicleAlert(AlertPriority.MEDIUM, "Tire pressure is high than maximum level", existingVehicle);
        }

    }
}
