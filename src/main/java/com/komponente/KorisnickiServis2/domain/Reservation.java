package com.komponente.KorisnickiServis2.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Vehicle vehicle;
    private Long userId;
    private Date date_from;
    private Date date_to;

    public Reservation() {
    }

    public Reservation(Long id, Vehicle vehicle, Long userId, Date date_from, Date date_to) {
        this.id = id;
        this.vehicle = vehicle;
        this.userId = userId;
        this.date_from = date_from;
        this.date_to = date_to;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }
}
