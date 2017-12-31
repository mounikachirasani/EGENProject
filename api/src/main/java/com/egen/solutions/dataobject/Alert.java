package com.egen.solutions.dataobject;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name    = "Alert.listAll", query = "SELECT alerts FROM Alert alerts"),
        @NamedQuery(name    = "Alert.alertPriority",
                query   = "SELECT alerts FROM Alert alerts WHERE alerts.alertPriority = :paramPriority"),
        @NamedQuery(name    = "Alert.alertByVin", query = "SELECT alerts FROM Alert alerts WHERE alerts.vehicle.vin = :paramVin"),
        @NamedQuery(name    = "Alert.alertPriorityandVin",
                query   = "SELECT alerts FROM Alert alerts WHERE alerts.alertPriority = :paramPriority AND alerts.vehicle.vin = :paramVin")
})
public class Alert {

    @Id
    private String id;

    private AlertPriority alertPriority;

    private String alertMessage;

    @ManyToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;

    public Alert() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AlertPriority getAlertPriority() {
        return alertPriority;
    }

    public void setAlertPriority(AlertPriority alertPriority) {
        this.alertPriority = alertPriority;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
