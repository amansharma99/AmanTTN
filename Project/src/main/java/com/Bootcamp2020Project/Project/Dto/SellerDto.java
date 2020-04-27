package com.Bootcamp2020Project.Project.Dto;

import javax.validation.constraints.NotNull;

public class SellerDto {
    @NotNull
    private String firstname;
    private String middlename;
    @NotNull
    private String lastname;
    @NotNull
    private String GST;
    @NotNull
    private Long companyContact;
    @NotNull
    private String companyName;

    public SellerDto(String firstname, String middlename, String lastname, String GST, Long companyContact, String companyName) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.GST = GST;
        this.companyContact = companyContact;
        this.companyName = companyName;
    }

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

    public String getGST() {
        return GST;
    }

    public void setGST(String GST) {
        this.GST = GST;
    }

    public Long getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(Long companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
