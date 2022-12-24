package com.komponente.KorisnickiServis2.domain;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Vehicle vehicle;
    @ManyToOne
    private Long userId;

    public Reservation() {
    }

    public Reservation(Long id, Vehicle vehicle, Long userId) {
        this.id = id;
        this.vehicle = vehicle;
        this.userId = userId;
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
}
