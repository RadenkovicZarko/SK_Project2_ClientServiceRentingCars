package com.komponente.KorisnickiServis2.dto;

import com.komponente.KorisnickiServis2.domain.Company;
import com.komponente.KorisnickiServis2.domain.Model;
import com.komponente.KorisnickiServis2.domain.Type;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class VehicleCreateDto {

    private int price;
    private Company company;
    private Model model;
    private Type type;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
