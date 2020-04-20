package com.Bootcamp2020Project.Project.Dto;

public class CustomerDto extends UserDto {

    private long contact=-1;


    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public CustomerDto(Long id, String firstName, String middleName, String lastName,Long Contact) {
        super(id,firstName,middleName,lastName);
      this.contact=Contact;
    }
}