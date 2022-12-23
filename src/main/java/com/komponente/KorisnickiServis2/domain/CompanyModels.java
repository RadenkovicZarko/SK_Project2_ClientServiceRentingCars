package com.komponente.KorisnickiServis2.domain;

import javax.persistence.*;

@Entity
public class CompanyModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Company id_company;
    @ManyToOne
    private Model id_model;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getId_company() {
        return id_company;
    }

    public void setId_company(Company id_company) {
        this.id_company = id_company;
    }

    public Model getId_model() {
        return id_model;
    }

    public void setId_model(Model id_model) {
        this.id_model = id_model;
    }
}
