package com.Bootcamp2020Project.Project.Dto;

public class SellerDto extends UserDto {

    private String GST;

    private String companyName;

    private Long companyContact;

    public SellerDto(Long id, String firstName, String middleName, String lastName) {
        super(id, firstName, middleName, lastName);
    }


    public String getGST() {
        return GST;
    }

    public void setGST(String GST) {
        this.GST = GST;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(Long companyContact) {
        this.companyContact = companyContact;
    }
}