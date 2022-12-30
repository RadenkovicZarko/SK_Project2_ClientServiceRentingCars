package com.komponente.KorisnickiServis2.client.userservice.dto;

public class ClientRentingDaysDto {

    private Long id;
    private int numOfDays;


    public ClientRentingDaysDto() {
    }

    public ClientRentingDaysDto(Long id, int numOfDays) {
        this.id = id;
        this.numOfDays = numOfDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }
}
