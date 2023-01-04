package com.komponente.KorisnickiServis2.dto;

public class SearchCompanyDto {
    private String companyName;
    private Long id;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SearchCompanyDto{" +
                "companyName='" + companyName + '\'' +
                ", id=" + id +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }
}
