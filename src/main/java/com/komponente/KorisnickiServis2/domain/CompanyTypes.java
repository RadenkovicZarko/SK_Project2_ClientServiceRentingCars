package com.komponente.KorisnickiServis2.domain;

import javax.persistence.*;

@Entity
public class CompanyTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Company id_company;
    @ManyToOne
    private Type id_type;

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

    public Type getId_type() {
        return id_type;
    }

    public void setId_type(Type id_type) {
        this.id_type = id_type;
    }
}
