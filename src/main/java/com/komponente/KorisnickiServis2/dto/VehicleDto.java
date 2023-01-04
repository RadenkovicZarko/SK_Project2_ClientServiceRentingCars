package com.komponente.KorisnickiServis2.dto;

import com.komponente.KorisnickiServis2.domain.Company;
import com.komponente.KorisnickiServis2.domain.Model;
import com.komponente.KorisnickiServis2.domain.Type;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class VehicleDto {
    private Long id;
    private int price;
    private String company;
    private String model;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
