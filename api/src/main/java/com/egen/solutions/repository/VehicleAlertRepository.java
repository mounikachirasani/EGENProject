package com.egen.solutions.repository;

import com.egen.solutions.dataobject.Alert;
import com.egen.solutions.dataobject.AlertPriority;

import java.util.List;

public interface VehicleAlertRepository {

    List<Alert> listAll();

    Alert create(Alert alertObj);

    Alert update(Alert alertObj);

    void delete(Alert alertObj);

    List<Alert> getVehicleAlertsByVin(String vehicleId);

    List<Alert> getVehicleAlertByVinandAlertPriority(String vehicleId, AlertPriority alertPriority);

}
