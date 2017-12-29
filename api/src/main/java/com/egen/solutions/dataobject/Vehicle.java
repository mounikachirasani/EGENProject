package com.egen.solutions.dataobject;


import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicle.listAll",
                query = "SELECT vehicle FROM Vehicle vehicle ORDER BY vehicle.make DESC"),
        @NamedQuery(name = "Vehicle.getById", query = "SELECT vehicle FROM Vehicle vehicle where vehicle.vin=:paramVehicleId")
})
public class Vehicle {

    @Id
    @Column(columnDefinition = "VARCHAR(17)")
    private String vin;

    private String make;
    private String model;
    private int year;
    private int redlineRpm;
    private Double maxFuelVolume;
    private Date lastServiceDate;


    public String getVin()
    {
        return vin;
    }

    public void setVin(String vin)
    {
        this.vin = vin;
    }

    public String getMake() {

        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public String getModel() {

        return model;
    }

    public void setModel(String model) {

        this.model = model;
    }

    public Integer getYear() {

        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(Integer redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public Double getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(Double maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
}