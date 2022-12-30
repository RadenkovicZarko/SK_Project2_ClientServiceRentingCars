package com.komponente.KorisnickiServis2.dto;

import com.komponente.KorisnickiServis2.domain.Company;

public class ChangeReviewDto {
    private String description;
    private Long rating;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
