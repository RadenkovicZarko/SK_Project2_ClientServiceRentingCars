package com.komponente.KorisnickiServis2.dto;

import com.komponente.KorisnickiServis2.domain.Company;

import javax.persistence.ManyToOne;

public class ReviewDto {
    private String description;
    private Long user_id;
    private Company company;
    private Long rating;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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
