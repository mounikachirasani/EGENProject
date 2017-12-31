package com.egen.solutions.repository.impl;

import com.egen.solutions.dataobject.Alert;
import com.egen.solutions.dataobject.AlertPriority;
import com.egen.solutions.repository.VehicleAlertRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleAlertRepositoryImpl implements VehicleAlertRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Alert> listAll(){
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.listAll", Alert.class);
        return query.getResultList();
    }

    public Alert create(Alert alertObj) {
        entityManager.persist(alertObj);
        return alertObj;
    }

    public Alert update(Alert alertObj) {
        entityManager.merge(alertObj);
        return alertObj;
    }

    public void delete(Alert alertObj) {
        entityManager.remove(alertObj);

    }

    public List<Alert> getVehicleAlertsByVin(String vehicleId){
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.alertByVin", Alert.class);
        query.setParameter("paramVin", vehicleId);
        return query.getResultList();
    }

    public List<Alert> getVehicleAlertByVinandAlertPriority(String vehicleId, AlertPriority alertPriority){
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.alertPriorityandVin", Alert.class);
        query.setParameter("paramVin", vehicleId);
        query.setParameter("paramPriority", alertPriority);
        return query.getResultList();
    }
}
