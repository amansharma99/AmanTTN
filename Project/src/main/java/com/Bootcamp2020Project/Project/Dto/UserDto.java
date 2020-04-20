package com.Bootcamp2020Project.Project.Dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;

        @Size(min = 8,max = 15)
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",message = "Password should contain atleast 8 characters and one Uppercase,lowercase,digit and special character")
    private String password;

    private boolean isDeleted;
    private boolean isActive=true;

    public UserDto(Long id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    public UserDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}