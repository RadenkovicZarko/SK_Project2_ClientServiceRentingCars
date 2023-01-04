package com.komponente.KorisnickiServis2.domain;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String description;
    @ManyToOne
    private Company company;
    private Long rating;

    public Review() {
    }

    public Review(Long userId, String description, Company company, Long rating) {
        this.userId = userId;
        this.description = description;
        this.company = company;
        this.rating = rating;
    }

    public Review(Long id, Long userId, String description, Company company, Long rating) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.company = company;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
