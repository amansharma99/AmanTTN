package com.Bootcamp2020Project.Project.Dto;

public class CustomerRegistrationDto extends UserRegistrationDto {

    private String contact;


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}