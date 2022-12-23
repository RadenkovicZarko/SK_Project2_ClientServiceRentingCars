package com.komponente.KorisnickiServis2.domain;

import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int price;
    @ManyToOne
    private Company company;
    @OneToOne
    private Model model;
    @OneToOne
    private Type type;

    public Vehicle() {
    }

    public Vehicle(Long id, int price, Company company, Model model, Type type) {
        this.id = id;
        this.price = price;
        this.company = company;
        this.model = model;
        this.type = type;
    }

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
