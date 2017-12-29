package com.egen.solutions.repository.impl;

import com.egen.solutions.dataobject.Vehicle;
import com.egen.solutions.repository.VehicleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> listAll() {

        TypedQuery<Vehicle> query = entityManager.createNamedQuery( "Vehicle.listAll", Vehicle.class);
        return query.getResultList();
    }

    public Vehicle getById(String vehicleId) {

        return entityManager.find(Vehicle.class, vehicleId);
    }

    public Vehicle create(Vehicle vehicleObj) {
        entityManager.persist(vehicleObj);
        return vehicleObj;
    }

    public Vehicle update(Vehicle vehicleObj) {
        entityManager.merge(vehicleObj);
        return vehicleObj;
    }

    public void delete(Vehicle vehicleObj) {
        entityManager.remove(vehicleObj);

    }
}
