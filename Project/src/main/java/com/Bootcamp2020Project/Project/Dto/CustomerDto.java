package com.Bootcamp2020Project.Project.Dto;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

public class CustomerDto {
    @NotNull
    private String firstname;
    private String middlename;
    private String lastname;
    @NotNull
    private Long contact;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }
}
