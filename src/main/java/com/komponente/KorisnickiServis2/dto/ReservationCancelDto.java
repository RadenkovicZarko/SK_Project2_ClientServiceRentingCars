package com.komponente.KorisnickiServis2.dto;

import com.komponente.KorisnickiServis2.domain.Vehicle;

import java.util.Date;

public class ReservationCancelDto {
    private Long id;
    private Long id_vehicle;
    private Long userId;
    private Date date_from;
    private Date date_to;
    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_vehicle() {
        return id_vehicle;
    }

    public void setId_vehicle(Long id_vehicle) {
        this.id_vehicle = id_vehicle;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ReservationCancelDto{" +
                "id=" + id +
                ", id_vehicle=" + id_vehicle +
                ", userId=" + userId +
                ", date_from=" + date_from +
                ", date_to=" + date_to +
                ", price=" + price +
                '}';
    }
}
